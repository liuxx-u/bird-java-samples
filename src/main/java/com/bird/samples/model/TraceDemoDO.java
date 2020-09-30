package com.bird.samples.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bird.service.common.model.StringDO;
import com.bird.service.common.trace.TraceField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author liuxx
 * @since 2020/9/30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("trace_demo")
public class TraceDemoDO extends StringDO {

    @TraceField("名称")
    private String name;

    @TableField
    private String description;

    private Integer num;

    @TraceField("日期")
    private Date date;
}
