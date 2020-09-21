package com.bird.samples.controller;

import com.bird.samples.pojo.DemoBO;
import com.bird.web.common.version.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * /v1/api/json
 * /v2/api/json
 *
 * @author liuxx
 * @since 2020/9/21
 */
@ApiVersion("v1")
@RestController
@RequestMapping("/api")
public class ApiVersionController {

    @GetMapping("/json")
    public DemoBO json(){
        return new DemoBO("v1");
    }

    @ApiVersion("v2")
    @GetMapping("/json")
    public DemoBO jsonV2(){
        return new DemoBO("v2");
    }
}
