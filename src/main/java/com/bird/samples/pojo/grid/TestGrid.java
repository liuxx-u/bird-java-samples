package com.bird.samples.pojo.grid;

import com.bird.service.common.grid.annotation.AutoGrid;
import com.bird.service.common.grid.annotation.GridField;
import com.bird.service.common.model.StringDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author liuxx
 * @since 2021/2/2
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoGrid(name = "demo",from = "demo")
public class TestGrid extends StringDO {

    private String id;

    private String name;

    @GridField(dbField = "`date`")
    private Date date;

    private String description;

    private Integer num;
}
