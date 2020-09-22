package com.bird.samples.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bird.service.common.model.StringDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author liuxx
 * @since 2020/9/22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("demo")
public class DemoDO extends StringDO {

    private String name;

    private String description;

    private Integer num;

    private Date date;
}
