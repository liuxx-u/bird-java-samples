package com.bird.samples.controller;

import com.bird.core.NameValue;
import com.bird.samples.pojo.DemoBO;
import com.bird.web.common.version.ApiVersion;
import org.springframework.web.bind.annotation.*;

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
    public DemoBO json() {
        return new DemoBO("v1");
    }

    @ApiVersion("v2")
    @GetMapping("/json")
    public DemoBO jsonV2() {
        return new DemoBO("v2");
    }

    @PostMapping("/read-json")
    public NameValue readJson(@RequestBody NameValue body) {
        return body;
    }

    @PostMapping(value = "/read-url")
    public NameValue readJson(@RequestParam String name, @RequestParam String value) {
        return new NameValue(name, value);
    }
}
