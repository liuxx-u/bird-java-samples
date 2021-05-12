package com.bird.samples.statemachine.shopping.define;

/**
 * @author liuxx
 * @since 2021/5/12
 */
public interface ShopConstant {

    String MACHINE_ID = "shopping";

    interface State {
        /**
         * 待支付
         */
        String WAIT_PAY = "WAIT_PAY";
        /**
         * 支付中
         */
        String PAY_IN_PROGRESS = "PAY_IN_PROGRESS";
        /**
         * 已支付
         */
        String PAID = "PAID";
        /**
         * 支付取消
         */
        String PAY_CANCEL = "PAY_CANCEL";
        /**
         * 卖家已发货
         */
        String DELIVERED = "DELIVERED";
        /**
         * 买家已收货
         */
        String RECEIVED = "RECEIVED";
    }

    interface Event {
        /**
         * 发起支付
         */
        String START_PAY = "START_PAY";
        /**
         * 支付成功通知
         */
        String PAID_NOTIFY = "PAID_NOTIFY";
        /**
         * 支付超时
         */
        String PAY_TIMEOUT = "PAY_TIMEOUT";
        /**
         * 卖家发货
         */
        String DELIVERY = "DELIVERY";
        /**
         * 买家收货
         */
        String RECEIVING = "RECEIVING";
        /**
         * 自动收货
         */
        String AUTO_RECEIVING = "AUTO_RECEIVING";
    }
}
