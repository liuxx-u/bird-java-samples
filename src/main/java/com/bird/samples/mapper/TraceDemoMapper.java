package com.bird.samples.mapper;

import com.bird.samples.model.TraceDemoDO;
import com.bird.service.common.mapper.AbstractMapper;
import org.springframework.stereotype.Repository;

/**
 * @author liuxx
 * @since 2020/9/30
 */
@Repository
public interface TraceDemoMapper extends AbstractMapper<TraceDemoDO> {

    void updateName();
}
