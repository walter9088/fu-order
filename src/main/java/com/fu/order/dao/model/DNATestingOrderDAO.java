package com.fu.order.dao.model;

import java.util.Date;

/**
 * Created by walter on 17/7/16.
 */
public class DNATestingOrderDAO {

    /**id*/
    private int id;

    /**有赞id*/
    private long orderId;

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

    private String status;

    private Date gmt_create;

    private Date gmt_modify;

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
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

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modify() {
        return gmt_modify;
    }

    public void setGmt_modify(Date gmt_modify) {
        this.gmt_modify = gmt_modify;
    }
}
