package com.bird.samples.controller;

import com.bird.core.NameValue;
import com.bird.core.Result;
import com.bird.lock.DistributedLockTemplate;
import com.bird.lock.IDistributedLock;
import com.bird.lock.aspect.DistributedLock;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuxx
 * @since 2020/12/2
 */
@RestController
@RequestMapping("/lock")
public class LockController {

    private final IDistributedLock distributedLock;
    private final DistributedLockTemplate lockTemplate;

    public LockController(IDistributedLock distributedLock,DistributedLockTemplate lockTemplate){
        this.distributedLock = distributedLock;
        this.lockTemplate = lockTemplate;
    }

    public void lockTest(){
        if(this.distributedLock.tryLock("lockKey")){
            try {
                System.out.println("do something");
            }finally {
                this.distributedLock.unLock("lockKey");
            }
        }else {
            System.out.println("get lock failed");
        }
    }

    public void templateTest() {
        this.lockTemplate.withLock("lockKey", () -> {
            System.out.println("do something");
            return null;
        });
    }

    @GetMapping("/test")
    @DistributedLock(key = "test:{#name}_{#remark}")
    public Result<String> test(String name,String remark){
        return Result.success("success",name);
    }

    @PostMapping("/postTest")
    @DistributedLock(key = "test:{#nameValue.label}_{#nameValue.value}_{#name}")
    public NameValue postTest(@RequestBody NameValue nameValue,String name){
        return nameValue;
    }
}
