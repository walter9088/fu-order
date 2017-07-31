package com.fu.order.dto;

/**
 * Created by walter on 17/7/23.
 */
public class LogisticsDto {

    private int id;         //原始单据id
    private int logisticsId;//物流运输单

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(int logisticsId) {
        this.logisticsId = logisticsId;
    }
}
