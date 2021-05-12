package com.bird.samples.web.support.controller;

import com.bird.core.exception.UserArgumentException;
import com.bird.core.exception.UserFriendlyException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * 全局异常处理测试
 *
 * @author liuxx
 * @since 2020/9/21
 */
@Validated
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/userFriendly")
    public void userFriendly() {
        throw new UserFriendlyException("oh..exception");
    }

    @GetMapping("/userArgument")
    public void userArgument() {
        throw new UserArgumentException("oh..exception");
    }

    @GetMapping("/illegalArgument")
    public void illegalArgument() {
        throw new IllegalArgumentException("oh..exception");
    }

    @GetMapping("/runtime")
    public void runtime() {
        throw new RuntimeException("oh..exception");
    }

    @GetMapping("/other")
    public void other() throws Exception {
        throw new Exception("oh..exception");
    }

    @GetMapping("/valid")
    public void valid(@NotBlank(message = "参数不能为空") String param) {
        System.out.println(param);
    }
}
