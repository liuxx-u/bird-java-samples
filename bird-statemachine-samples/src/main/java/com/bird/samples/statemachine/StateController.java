package com.bird.samples.statemachine;

import com.bird.samples.statemachine.shopping.define.OrderContext;
import com.bird.samples.statemachine.shopping.define.OrderPayContext;
import com.bird.samples.statemachine.shopping.define.ShopConstant;
import com.bird.statemachine.factory.StateMachineFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxx
 * @since 2021/5/12
 */
@RestController
public class StateController {

    @GetMapping("/shopping/wxPay")
    public String startWxPay() {
        OrderPayContext context = new OrderPayContext();
        context.setPayMethod("WxPay");

        return this.fireEvent(ShopConstant.State.WAIT_PAY, ShopConstant.Event.START_PAY, context);
    }

    @GetMapping("/shopping/aliPay")
    public String startAliPay() {
        OrderPayContext context = new OrderPayContext();
        context.setPayMethod("AliPay");

        return this.fireEvent(ShopConstant.State.WAIT_PAY, ShopConstant.Event.START_PAY, context);
    }

    @GetMapping("/shopping/paidNotify")
    public String paidNotify() {
        return this.fireEvent(ShopConstant.State.PAY_IN_PROGRESS, ShopConstant.Event.PAID_NOTIFY, new OrderContext());
    }

    private String fireEvent(String state, String event, OrderContext orderContext) {

        return StateMachineFactory.get(ShopConstant.MACHINE_ID).fireEvent(state, event, orderContext);
    }
}
