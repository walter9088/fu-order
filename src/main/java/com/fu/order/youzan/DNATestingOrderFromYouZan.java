package com.fu.order.youzan;

import com.fu.order.dao.mapper.DNATestingOrder;
import com.fu.order.dao.model.DNATestingOrderDAO;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradesSoldGetResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by walter on 17/7/12.
 */
@Configuration
@Component
public class DNATestingOrderFromYouZan {

    private static Logger logger = LoggerFactory.getLogger(DNATestingOrderFromYouZan.class);

    @Resource
    private DNATestingOrder order;


    public void getDNATestingOrderFromYouZan(YouzanTradesSoldGetResult.TradeDetailV2 tradesDetailV2) {

        /**
         * 只关注等待卖家发货订单
         */
        if (null != tradesDetailV2 && StringUtils.equals("WAIT_SELLER_SEND_GOODS",tradesDetailV2.getStatus())) {

            DNATestingOrderDAO orderDAO = new DNATestingOrderDAO();

            StringBuffer sb = new StringBuffer("");

            /**收货地址*/
            sb.append(tradesDetailV2.getReceiverState()).append(tradesDetailV2.getReceiverCity())
                    .append(tradesDetailV2.getReceiverDistrict())
                    .append(tradesDetailV2.getReceiverAddress());

            orderDAO.setReceiverAddress(sb.toString());

            /**收货人手机号*/
            orderDAO.setReceiverMobile(tradesDetailV2.getReceiverMobile());

            /**收货人姓名*/
            orderDAO.setReceiverName(tradesDetailV2.getReceiverName());

            /**交易订单Id*/
            orderDAO.setTradeId(tradesDetailV2.getTid());

            /**创建时间*/
            orderDAO.setGmt_modify(new Date());

            /**更新时间*/
            orderDAO.setGmt_create(new Date());

            /**交易id*/
            orderDAO.setTradeId(tradesDetailV2.getTid());

            /** get orders */
            YouzanTradesSoldGetResult.TradeOrderV2[] tradeOrderV2s = tradesDetailV2.getOrders();
            if (null != tradeOrderV2s && tradeOrderV2s.length > 0) {
                /**一笔交易有多个order,说实话，我也没搞明白是什么鬼*/
                for (YouzanTradesSoldGetResult.TradeOrderV2 tradeOrderV2s1 : tradeOrderV2s) {

                    orderDAO.setOrderId(tradeOrderV2s1.getOid());
                    YouzanTradesSoldGetResult.TradeBuyerMessage[] tradeBuyerMessages = tradeOrderV2s1.getBuyerMessages();

                    if (null != tradeBuyerMessages && tradeBuyerMessages.length == 3) {

                        orderDAO.setAssayMobile(tradeBuyerMessages[0].getContent());
                        orderDAO.setAssayCard(tradeBuyerMessages[1].getContent());
                        orderDAO.setAssayName(tradeBuyerMessages[2].getContent());
                        /**生成order记录**/
                        order.insertYouZanOrder(orderDAO);
                    }

                }


            }
        }

    }


}
