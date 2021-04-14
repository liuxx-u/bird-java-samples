package com.bird.samples.pojo.grid;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.bird.service.common.grid.annotation.AutoGrid;
import com.bird.service.common.grid.annotation.GridField;
import com.bird.service.common.grid.enums.QueryStrategyEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author liuxx
 * @since 2021/2/5
 */
@Data
@AutoGrid(name = "demo2",from = "demo left join demo2 on demo.name=demo2.name",mainTable = "demo")
public class MultiTestGrid {

    @GridField(dbField = "`demo`.`id`")
    private String id;

    @GridField(dbField = "`demo`.`name`")
    private String name;

    @GridField(dbField = "`demo2`.`date`")
    private Date date;

    @GridField(dbField = "`demo`.`description`")
    private String description;

    @GridField(dbField = "`demo`.`num`")
    private Integer num;

    @TableLogic
    @GridField(dbField = "`demo`.`delFlag`",queryStrategy = QueryStrategyEnum.HIDE)
    private Boolean delFlag;
}
