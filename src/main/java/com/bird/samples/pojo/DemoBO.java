package com.bird.samples.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author liuxx
 * @since 2020/9/9
 */
@Data
public class DemoBO {
    private String name;

    private Integer count;

    private Date createTime;

    public DemoBO(){
        this.createTime = new Date();
    }

    public DemoBO(String name){
        this.name = name;
    }
}
