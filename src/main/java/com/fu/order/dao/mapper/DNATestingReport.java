package com.fu.order.dao.mapper;

import com.fu.order.dao.model.DNATestingReportDAO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by walter on 17/7/17.
 */
public interface DNATestingReport {

    String ADD_DNATESTING_REPORT="insert into t_assay_result (order_id,assay_name,assay_mobile,assay_card,assay_score,assay_result," +
            "specimen_type,specimen_quality,assay_date,report_date,inspector,reviewer,status,gmt_create,gmt_modify) " +
            "values(#{orderId},#{assayName},#{assayMobile},#{assayCard},#{assayScore},#{assayResult},#{specimenType},#{specimenQuality},#{assayDate}," +
            "#{reportDate},#{inspector},#{reviewer},'DNA_TESTING',#{gmt_create},#{gmt_modify})";

    String UPDATE_DNATESTING_REPORT="update t_assay_result set assay_score=#{assayScore},assay_result=#{assayResult},specimen_type=#{specimenType}," +
            "specimen_quality=#{specimenQuality},assay_date=#{assayDate},report_date=#{reportDate},inspector=#{inspector}," +
            "reviewer=#{reviewer},statu=#{status},gmt_modify=#{gmt_modify} where order_id=#{orderId} ";

    String SELECT_DNATESTING_REPORT="select order_id,assay_name,assay_mobile,assay_card,assay_score,assay_result," +
            "specimen_type,specimen_quality,assay_date,report_date,inspector,reviewer,gmt_create,gmt_modify from t_assay_result" +
            " where order_id=#{0} and status='REPORT' ";

    @Insert(ADD_DNATESTING_REPORT)
    public int addAssayReport(DNATestingReportDAO report);

    @Update(UPDATE_DNATESTING_REPORT)
    public int updateReport(DNATestingReportDAO report);


    @Select(SELECT_DNATESTING_REPORT)
    public DNATestingReport getDNATestingReport(String orderId);

}
