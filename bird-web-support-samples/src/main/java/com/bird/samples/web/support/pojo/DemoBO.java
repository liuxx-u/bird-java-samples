package com.bird.samples.web.support.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author liuxx
 * @since 2020/9/9
 */
@Data
public class DemoBO {

    private String name;

    private String description;

    private Integer num;

    private Date date;

    public DemoBO() {
    }

    public DemoBO(String name) {
        this.name = name;
    }
}
