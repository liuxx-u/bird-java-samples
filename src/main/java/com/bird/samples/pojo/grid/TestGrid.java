package com.bird.samples.pojo.grid;

import com.bird.service.common.grid.annotation.AutoGrid;
import com.bird.service.common.grid.annotation.GridField;
import com.bird.service.common.grid.define.StringAutoGrid;
import com.bird.service.common.grid.enums.QueryStrategyEnum;
import com.bird.service.common.grid.interceptor.IGridQueryInterceptor;
import com.bird.service.common.service.query.PagedListQuery;
import com.bird.service.common.service.query.PagedResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author liuxx
 * @since 2021/2/2
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoGrid(name = "demo",from = "demo",queryInterceptorClass = TestGrid.TestGridHandler.class )
public class TestGrid extends StringAutoGrid {

    private String id;

    @GridField(dbField = "{`name`}",queryStrategy = QueryStrategyEnum.FORBID)
    private String name;

    @GridField(dbField = "`date`")
    private Date date;

    private String description;

    private Integer num;

    @Component
    public static class TestGridHandler implements IGridQueryInterceptor{

        @Override
        public void preQuery(PagedListQuery pagedQuery) {
            System.out.println("preQuery");
        }

        @Override
        public void afterQuery(PagedResult<Map<String, Object>> pagedResult) {
            System.out.println("afterQuery");
        }
    }
}
