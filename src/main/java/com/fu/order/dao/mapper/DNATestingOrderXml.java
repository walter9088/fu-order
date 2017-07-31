package com.fu.order.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by walter on 17/7/20.
 */
public interface DNATestingOrderXml {

    public int updateOrderStatusById(@Param("ids") List<Integer> ids, @Param("status") String status,@Param("date") Date date);
}
