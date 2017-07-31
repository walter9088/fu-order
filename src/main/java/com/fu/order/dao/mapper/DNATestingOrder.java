package com.fu.order.dao.mapper;

import com.fu.order.dao.model.DNATestingOrderDAO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by walter on 17/7/16.
 */
@Mapper
public interface DNATestingOrder {

    String ADD_DNATESTING_ORDER="insert into t_dantesting_order(trade_id,order_id,receiver_address,receiver_name," +
            "receiver_mobile,assay_name,assay_mobile,assay_card,status,gmt_create,gmt_modify) " +
            "values(#{tradeId},#{orderId},#{receiverAddress},#{receiverName},#{receiverMobile},#{assayName}," +
            "#{assayMobile},#{assayCard},'INIT',#{gmt_create},#{gmt_modify})";


    String SELECT_DNATESTING_ORDER="select id,trade_id, order_id,receiver_address,receiver_name,receiver_mobile,assay_name," +
            "assay_mobile,assay_card,status,gmt_create,gmt_modify from t_dantesting_order where status='INIT'";

    String SELECT_DNATESTING_ORDER_BY_ORDERID="select id, trade_id, order_id,receiver_address,receiver_name,receiver_mobile,assay_name," +
            "assay_name,assay_mobile,assay_card,status,gmt_create,gmt_modify from t_dantesting_order where order_id in (#{0})";


    /** 新获取order */
    @Insert(ADD_DNATESTING_ORDER)
    public int insertYouZanOrder(DNATestingOrderDAO dao);


    @Select(SELECT_DNATESTING_ORDER)
    @Results({@Result(property = "id",column="id"),@Result(property = "tradeId",column="trade_id"),@Result(property = "orderId",column="order_id"),
            @Result(property = "receiverAddress",column = "receiver_address"),@Result(property = "receiverMobile",column = "receiver_mobile"),
            @Result(property = "receiverName",column = "receiver_name"),
            @Result(property = "assayName",column="assay_name"),@Result(property = "assayMobile",column="assay_mobile"),@Result(property = "assayCard",column="assay_card")
            ,@Result(property = "status",column="status")})
    public List<DNATestingOrderDAO> getDNATestingOrders();


    @Select(SELECT_DNATESTING_ORDER_BY_ORDERID)
    @Results({@Result(property = "id",column="id"),@Result(property = "tradeId",column="trade_id"),@Result(property = "orderId",column="order_id"),
            @Result(property = "receiverAddress",column = "receiver_address"),@Result(property = "receiverMobile",column = "receiver_mobile"),
            @Result(property = "receiverName",column = "receiver_name"),
            @Result(property = "assayName",column="assay_name"),@Result(property = "assayMobile",column="assay_mobile"),@Result(property = "assayCard",column="assay_card")
            ,@Result(property = "status",column="status")})
    public List<DNATestingOrderDAO> getDNATestingOrdersByOrderId(List<Long> orderIds);




}
