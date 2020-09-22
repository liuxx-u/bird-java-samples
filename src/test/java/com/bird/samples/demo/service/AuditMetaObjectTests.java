package com.bird.samples.demo.service;

import com.bird.core.session.BirdSession;
import com.bird.core.session.SessionContext;
import com.bird.samples.model.DemoDO;
import com.bird.samples.model.FullDemoDO;
import com.bird.samples.service.DemoService;
import com.bird.samples.service.FullDemoService;
import com.bird.service.common.incrementer.UUIDHexGenerator;
import com.bird.service.common.model.StringPureDO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author liuxx
 * @since 2020/9/22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class AuditMetaObjectTests {

    private final static String USER_ID = "liu";
    private final static String USER_ID2 = "mark";

    @Autowired
    private DemoService demoService;

    @Autowired
    private FullDemoService fullDemoService;

    @Test
    void insertTests() {
        DemoDO demo = new DemoDO();
        String id = UUIDHexGenerator.generate();
        demo.setId(id);
        demo.setName("test");

        demoService.insert(demo);

        DemoDO existDemo = demoService.getById(id);
        Assert.assertNotNull(existDemo.getCreateTime());
        Assert.assertNotNull(existDemo.getModifiedTime());
    }

    @Test
    void insertTests2() {
        FullDemoDO demo = new FullDemoDO();
        String id = UUIDHexGenerator.generate();
        demo.setId(id);
        demo.setName("test");

        this.initSession();

        fullDemoService.insert(demo);

        FullDemoDO existDemo = fullDemoService.getById(id);
        Assert.assertNotNull(existDemo.getCreateTime());
        Assert.assertNotNull(existDemo.getModifiedTime());
        Assert.assertEquals(existDemo.getCreatorId(), USER_ID);
        Assert.assertEquals(existDemo.getModifierId(), USER_ID);
    }

    @Test
    void updateTest() {
        DemoDO demo = demoService.lambdaQuery().orderByDesc(StringPureDO::getId).last("limit 1").one();
        if (demo != null) {
            String id = demo.getId();
            Date lastModifiedTime = demo.getModifiedTime();
            demo.setName("modify test");
            demoService.update(demo);

            demo = demoService.getById(id);
            Assert.assertNotEquals(lastModifiedTime.getTime(), demo.getModifiedTime().getTime());
        }
    }

    @Test
    void updateTest2() {
        FullDemoDO demo = fullDemoService.lambdaQuery().orderByDesc(StringPureDO::getId).last("limit 1").one();
        if (demo != null) {
            this.initSession2();

            String id = demo.getId();
            Date lastModifiedTime = demo.getModifiedTime();
            demo.setName("modify test");
            fullDemoService.update(demo);

            demo = fullDemoService.getById(id);
            Assert.assertNotEquals(lastModifiedTime.getTime(), demo.getModifiedTime().getTime());
            Assert.assertEquals(demo.getModifierId(), USER_ID2);
        }
    }

    private void initSession(){
        BirdSession session = new BirdSession();
        session.setUserId(USER_ID);

        SessionContext.setSession(session);
    }

    private void initSession2(){
        BirdSession session = new BirdSession();
        session.setUserId(USER_ID2);

        SessionContext.setSession(session);
    }
}
