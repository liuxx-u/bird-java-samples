package com.bird.samples.web.support.controller;

import com.bird.samples.web.support.pojo.DemoBO;
import com.bird.web.common.advice.JsonWrapperIgnore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JSON结果自动包装测试
 *
 * bird.web.global-result-wrapper 是否开启全局JSON结果包装，默认为true
 * bird.web.base-packages 在指定的包路径下的接口才进行自动包装
 *
 * @author liuxx
 * @since 2020/9/21
 */
@RestController
@RequestMapping("/json/wrapper")
public class JsonWrapperController {

    @GetMapping("/auto")
    public DemoBO autoWrapper(){
        return new DemoBO();
    }

    @JsonWrapperIgnore
    @GetMapping("/ignore")
    public DemoBO ignoreWrapper(){
        return new DemoBO();
    }

    /**
     * 原始类型与原始封装类型不支持自动进行结果包装
     * 两种方式可支持：
     * 1、接口定义为Result<String>进行返回
     * 2、自定义HttpMessageConverters，并设置支持的媒体类型，如：converter.setSupportedMediaTypes(ImmutableList.of(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN))
     */
    @GetMapping("/auto/string")
    public String autoString(){
        return "test string";
    }
}
