package com.bird.samples.support;

import com.bird.service.common.trace.IFieldTraceRecorder;
import com.bird.service.common.trace.define.FieldTraceDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuxx
 * @since 2020/9/30
 */
@Slf4j
@Component
public class FieldTraceLogRecorder implements IFieldTraceRecorder {
    /**
     * 记录信息
     *
     * @param record 字段更新记录列表
     */
    @Override
    public void record(List<FieldTraceDefinition> record) {
        for(FieldTraceDefinition trace : record){
            log.info(trace.toString());
        }
    }
}
