package com.bird.samples.pojo;

import com.bird.eventbus.arg.EventArg;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liuxx
 * @since 2020/11/20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TestArg extends EventArg {
    private String name;

    public TestArg(){}

    public TestArg(String name){
        super();
        this.name = name;
    }
}
