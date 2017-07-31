package com.fu.order.dto;

import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradesSoldGetResult;

/**
 * Created by walter on 17/7/23.
 */
public class MsgEntity {

    public YouzanTradesSoldGetResult.TradeDetailV2 trade;


    public YouzanTradesSoldGetResult.TradeDetailV2 getTrade() {
        return trade;
    }

    public void setTrade(YouzanTradesSoldGetResult.TradeDetailV2 trade) {
        this.trade = trade;
    }
}
