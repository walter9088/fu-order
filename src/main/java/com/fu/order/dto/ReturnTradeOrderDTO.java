package com.fu.order.dto;

import java.util.List;

/**
 * Created by walter on 17/7/18.
 */
public class ReturnTradeOrderDTO {

    /**交易id*/
    private String tradeId;

    /**收货地址*/
    private String receiverAddress;

    /**收货人姓名*/
    private String receiverName;

    /**收货人手机*/
    private String receiverMobile;

    private List<DNATestingOrderDTO> orderDTOs;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public List<DNATestingOrderDTO> getOrderDTOs() {
        return orderDTOs;
    }

    public void setOrderDTOs(List<DNATestingOrderDTO> orderDTOs) {
        this.orderDTOs = orderDTOs;
    }
}
