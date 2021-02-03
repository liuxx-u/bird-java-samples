package com.bird.samples.mapper;

import com.bird.samples.model.DemoDO;
import com.bird.service.common.mapper.AbstractMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liuxx
 * @since 2020/9/22
 */
@Repository
public interface DemoMapper extends AbstractMapper<DemoDO> {

    void deleteAll();

    void updateTest(@Param("id") String  id,@Param("name") String name);
}
