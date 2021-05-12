package com.bird.samples.statemachine.shopping;

import com.bird.samples.statemachine.shopping.define.OrderContext;
import com.bird.samples.statemachine.shopping.define.ShopConstant;
import com.bird.statemachine.StateProcessor;
import com.bird.statemachine.initialize.annotation.StateHandler;
import org.springframework.stereotype.Component;

/**
 * @author liuxx
 * @since 2021/5/12
 */

@Component
@StateHandler(machineId = ShopConstant.MACHINE_ID,state = ShopConstant.State.PAY_IN_PROGRESS,event = ShopConstant.Event.PAID_NOTIFY)
public class PaidProcessor implements StateProcessor<OrderContext> {
    @Override
    public String action(OrderContext context) {

        System.out.println("paid notify");
        return null;
    }
}
