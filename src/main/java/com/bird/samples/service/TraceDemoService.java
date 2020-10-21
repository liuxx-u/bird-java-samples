package com.bird.samples.service;

import com.bird.core.exception.UserFriendlyException;
import com.bird.core.trace.Traceable;
import com.bird.samples.mapper.TraceDemoMapper;
import com.bird.samples.model.TraceDemoDO;
import com.bird.service.common.model.StringPureDO;
import com.bird.service.common.service.AbstractStringService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author liuxx
 * @since 2020/9/30
 */
@Service
public class TraceDemoService extends AbstractStringService<TraceDemoMapper, TraceDemoDO> {


    public void updateName(){
        mapper.updateName();
    }

    @Traceable("updateFirst")
    public String updateFirst(){
        TraceDemoDO first = lambdaQuery().last("limit 1").one();

        first.setName(UUID.randomUUID().toString());
        super.update(first);

        return first.getName();
    }


    @Traceable("updateLast")
    @Transactional(rollbackFor = Exception.class)
    public String updateLast(){
        return this.updateLast2();
    }

    @Traceable("updateLast2")
    public String updateLast2(){
        TraceDemoDO last = lambdaQuery().orderByDesc(StringPureDO::getId).last("limit 1").one();

        last.setName(UUID.randomUUID().toString());
        super.update(last);

        throw new RuntimeException("error");
    }
}
