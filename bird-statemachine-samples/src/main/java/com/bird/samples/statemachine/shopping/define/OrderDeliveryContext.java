package com.bird.samples.statemachine.shopping.define;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liuxx
 * @since 2021/5/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDeliveryContext extends OrderContext{

    /**
     * 物流方式：顺丰、圆通、中通
     */
    private String deliveryType;
}
