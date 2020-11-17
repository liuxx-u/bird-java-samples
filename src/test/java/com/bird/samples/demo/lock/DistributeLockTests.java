package com.bird.samples.demo.lock;

import com.bird.core.exception.UserFriendlyException;
import com.bird.lock.IDistributedLock;
import com.bird.lock.reject.ExceptionRejectStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liuxx
 * @since 2020/11/17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class DistributeLockTests {

    @Autowired
    private IDistributedLock distributedLock;

    @Test
    void asyncCount30Test() throws InterruptedException {
        Counter counter = new Counter();
        CountDownLatch countDownLatch = new CountDownLatch(30);

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                counter.increase();
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        Assert.assertTrue(counter.get() < 30);
    }

    @Test
    void asyncLockCount30Test() throws InterruptedException {
        Counter counter = new Counter();
        CountDownLatch countDownLatch = new CountDownLatch(30);

        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(() -> distributedLock.withLock("lockKey", () -> {
                counter.increase();
                countDownLatch.countDown();
                return true;
            }, 30, 1000));
            thread.start();
        }
        countDownLatch.await();
        Assert.assertEquals(counter.get(), 30);
    }

    @Test
    void asyncLockCount30ExceptionTest() throws InterruptedException {
        Counter counter = new Counter();
        Counter result = new Counter();
        CountDownLatch countDownLatch = new CountDownLatch(30);

        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(() -> distributedLock.withLock("lockKey", () -> {
                counter.increase();
                countDownLatch.countDown();
                if(counter.get() <= 10){
                    throw new RuntimeException("error");
                }
                result.increase();
                return true;
            }, 30, 1000));
            thread.start();
        }
        countDownLatch.await();
        Assert.assertEquals(result.get(), 20);
    }

    @Test
    void asyncReentrantLockCount30Test() throws InterruptedException {
        Counter counter = new Counter();
        CountDownLatch countDownLatch = new CountDownLatch(30);

        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(() -> {
                distributedLock.withLock("lockKey", () -> {
                    counter.increase();

                    distributedLock.withLock("lockKey", () -> {
                        counter.increase();
                        return true;
                    });
                    return true;
                }, 30, 1000);
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        Assert.assertEquals(counter.get(), 60);
    }

    @Test
    void asyncLockCount30TimeoutTest() throws InterruptedException {
        Counter counter = new Counter();
        CountDownLatch countDownLatch = new CountDownLatch(30);

        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(() -> {
                distributedLock.withLock("lockKey", () -> {
                    if (counter.get() == 0) {
                        System.out.println("sleep start");
                        counter.increase(0);
                        System.out.println("sleep end");
                    } else {
                        System.out.println("increase normal");
                        counter.increase();
                    }
                    return true;
                }, 50, 1000, 5000, new ExceptionRejectStrategy<>());
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        Assert.assertTrue(counter.get() < 30);
    }

    @Test
    void asyncReentrantLockCount30ExceptionTest() throws InterruptedException {
        Counter counter = new Counter();
        Counter result = new Counter();
        CountDownLatch countDownLatch = new CountDownLatch(59);

        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(() -> distributedLock.withLock("lockKey", () -> {
                counter.increase();
                countDownLatch.countDown();
                if(counter.get() == 1){
                    throw new RuntimeException("error");
                }

                distributedLock.withLock("lockKey", () -> {
                    counter.increase();
                    countDownLatch.countDown();

                    if(counter.get() == 3){
                        throw new RuntimeException("reentrant error");
                    }
                    result.increase();
                    return true;
                });
                return true;
            }, 30, 1000));
            thread.start();
        }
        countDownLatch.await();
        Assert.assertEquals(result.get(), 28);
    }

    static class Counter {

        private int count = 0;

        int get() {
            return this.count;
        }

        void increase() {
            increase(ThreadLocalRandom.current().nextInt(2));
        }

        void increase(long millis) {
            int n = count;
            try {
                // do something
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = n + 1;
        }
    }
}
