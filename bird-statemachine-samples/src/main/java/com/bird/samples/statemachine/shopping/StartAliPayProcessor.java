package com.bird.samples.statemachine.shopping;

import com.bird.samples.statemachine.shopping.define.OrderPayContext;
import com.bird.samples.statemachine.shopping.define.ShopConstant;
import com.bird.statemachine.StateProcessor;
import com.bird.statemachine.initialize.annotation.StateHandler;
import org.springframework.stereotype.Component;

/**
 * @author liuxx
 * @since 2021/5/12
 */
@Component
@StateHandler(machineId = ShopConstant.MACHINE_ID,state = ShopConstant.State.WAIT_PAY,event = ShopConstant.Event.START_PAY,sceneId = "AliPay")
public class StartAliPayProcessor implements StateProcessor<OrderPayContext> {

    @Override
    public String action(OrderPayContext context) {

        System.out.println("do alipay pay");
        return null;
    }
}
