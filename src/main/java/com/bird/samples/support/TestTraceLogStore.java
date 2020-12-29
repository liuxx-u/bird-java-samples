package com.bird.samples.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bird.core.trace.TraceDefinition;
import com.bird.core.trace.dispatch.ITraceLogStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuxx
 * @since 2020/10/9
 */
@Slf4j
//@Component
public class TestTraceLogStore implements ITraceLogStore {
    /**
     * 存储轨迹信息
     *
     * @param traceLogs 轨迹信息
     */
    @Override
    public void store(List<TraceDefinition> traceLogs) {
        for (TraceDefinition trace : traceLogs) {
            log.info(JSON.toJSONString(trace, SerializerFeature.DisableCircularReferenceDetect));
        }
    }
}
