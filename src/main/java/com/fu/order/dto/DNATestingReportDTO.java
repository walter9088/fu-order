package com.fu.order.dto;

import java.util.Date;

/**
 * Created by walter on 17/7/17.
 */
public class DNATestingReportDTO {


    private int id;

    /** 检验人姓名*/
    private String assayName;

    /** 检检人手机*/
    private String assayMobile;

    /** 检验人身份证号*/
    private String assayCard;

    /** 检测评分*/
    private String assayScore;

    /**检测质量*/
    private String assayResult;

    /**样本类型*/
    private String specimenType;

    /**样本质量*/
    private String specimenQuality;

    /**检测日期*/
    private Date assayDate;

    /**报告日期*/
    private Date reportDate;

    /**检测人*/
    private String inspector;

    /**复核人*/
    private String reviewer;

    private Date gmt_create;

    private Date gmt_modify;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAssayScore() {
        return assayScore;
    }

    public void setAssayScore(String assayScore) {
        this.assayScore = assayScore;
    }

    public String getAssayResult() {
        return assayResult;
    }

    public void setAssayResult(String assayResult) {
        this.assayResult = assayResult;
    }

    public String getSpecimenType() {
        return specimenType;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public String getSpecimenQuality() {
        return specimenQuality;
    }

    public void setSpecimenQuality(String specimenQuality) {
        this.specimenQuality = specimenQuality;
    }

    public Date getAssayDate() {
        return assayDate;
    }

    public void setAssayDate(Date assayDate) {
        this.assayDate = assayDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
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
