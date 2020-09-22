package com.bird.samples.service;

import com.bird.samples.mapper.DemoMapper;
import com.bird.samples.model.DemoDO;
import com.bird.service.common.service.AbstractStringService;
import org.springframework.stereotype.Service;

/**
 * @author liuxx
 * @since 2020/9/22
 */
@Service
public class DemoService extends AbstractStringService<DemoMapper, DemoDO> {
}
