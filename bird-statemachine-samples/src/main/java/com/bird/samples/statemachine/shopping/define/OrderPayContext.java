package com.bird.samples.statemachine.shopping.define;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liuxx
 * @since 2021/5/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderPayContext extends OrderContext{

    /**
     * 支付方式：WxPay、AliPay
     */
    private String payMethod;

    @Override
    public String getSceneId() {
        return this.payMethod;
    }
}
