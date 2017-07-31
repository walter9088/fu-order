package com.fu.order.dto;

/**
 * Created by walter on 17/7/17.
 */
public class DNATestingOrderDTO {

    public int id;

    /**有赞id*/
    private Long orderId;

    /**交易id*/
    private String tradeId;

    /**收货地址*/
    private String receiverAddress;

    /**收货人姓名*/
    private String receiverName;

    /**收货人手机*/
    private String receiverMobile;

    /**检验人姓名*/
    private String assayName;

    /**检验人手机*/
    private String assayMobile;

    /**检验人身份证号*/
    private String assayCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

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

    public String getAssayName() {
        return assayName;
    }

    public void setAssayName(String assayName) {
        this.assayName = assayName;
    }

    public String getAssayMobile() {
        return assayMobile;
    }

    public void setAssayMobile(String assayMobile) {
        this.assayMobile = assayMobile;
    }

    public String getAssayCard() {
        return assayCard;
    }

    public void setAssayCard(String assayCard) {
        this.assayCard = assayCard;
    }
}
