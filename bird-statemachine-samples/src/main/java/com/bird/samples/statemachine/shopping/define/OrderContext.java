package com.bird.samples.statemachine.shopping.define;

import com.bird.statemachine.StateContext;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liuxx
 * @since 2021/5/12
 */
@Data
public class OrderContext implements StateContext {

    /**
     * 订单编号
     */
    private String orderNum;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    /**
     * 下单渠道
     */
    private String channel;
    /**
     * 产品id
     */
    private String productId;
    /**
     * sku
     */
    private String skuId;

    public OrderContext(){}

    public OrderContext(String orderNum,String channel){
        this.orderNum = orderNum;
        this.channel = channel;
    }

    @Override
    public String getSceneId() {
        return this.channel;
    }
}
