package com.bird.samples.service;

import com.bird.samples.mapper.FullDemoMapper;
import com.bird.samples.model.FullDemoDO;
import com.bird.service.common.service.AbstractStringService;
import org.springframework.stereotype.Service;

/**
 * @author liuxx
 * @since 2020/9/22
 */
@Service
public class FullDemoService extends AbstractStringService<FullDemoMapper, FullDemoDO> {
}
