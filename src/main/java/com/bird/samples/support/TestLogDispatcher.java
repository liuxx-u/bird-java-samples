package com.bird.samples.support;

import com.bird.core.trace.TraceDefinition;
import com.bird.core.trace.dispatch.ITraceLogDispatcher;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author liuxx
 * @since 2020/10/9
 */
//@Component
public class TestLogDispatcher implements ITraceLogDispatcher {
    /**
     * 发送跟踪日志
     *
     * @param traceLogs 跟踪日志
     */
    @Override
    public void dispatch(Collection<TraceDefinition> traceLogs) {

    }
}
