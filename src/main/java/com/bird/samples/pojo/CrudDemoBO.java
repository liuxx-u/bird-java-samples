package com.bird.samples.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bird.service.common.service.dto.StringEntityBO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author liuxx
 * @since 2020/10/14
 */
@Data
@TableName("demo")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CrudDemoBO extends StringEntityBO {
    private String name;

    private String description;

    private Integer num;

    private Date date;
}
