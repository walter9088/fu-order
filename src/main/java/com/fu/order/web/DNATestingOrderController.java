package com.fu.order.web;

import com.alibaba.fastjson.JSON;
import com.fu.order.Enum.YouZanOrderEnum;
import com.fu.order.dao.mapper.DNATestingOrder;
import com.fu.order.dao.mapper.DNATestingOrderXml;
import com.fu.order.dao.mapper.DNATestingReport;
import com.fu.order.dao.model.DNATestingOrderDAO;
import com.fu.order.dao.model.DNATestingReportDAO;
import com.fu.order.dto.DNATestingOrderDTO;
import com.fu.order.dto.DNATestingReportDTO;
import com.fu.order.dto.LogisticsDto;
import com.fu.order.youzan.YouZanTokenCache;
import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanTradesSoldGet;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradesSoldGetParams;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradesSoldGetResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by walter on 17/7/16.
 */

@RestController
@Controller
public class DNATestingOrderController {

    private static Logger logger = LoggerFactory.getLogger(DNATestingOrderController.class);


    @Resource
    private DNATestingOrder order;

    @Resource
    private DNATestingOrderXml orderXml;

    @Resource
    private DNATestingReport report;


    /**
     * 诺辉get数据接口
     *
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/api/getDNATestingOrder.json", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public List<DNATestingOrderDTO> getDNATestingOrder() {

        logger.info("get DNATestingOrder=============!");
        List<DNATestingOrderDTO> orderDTOs = new ArrayList<>();

        /**获取状态为INIT的订单*/
        List<DNATestingOrderDAO> orders = order.getDNATestingOrders();

        if (null != orders && !orders.isEmpty()) {

            List<Integer> orderIds = new ArrayList<>();

            DNATestingOrderDTO orderDTO = null;
            for (DNATestingOrderDAO order : orders) {
                if (null != order) {

                    orderDTO = new DNATestingOrderDTO();
                    orderDTO.setTradeId(order.getTradeId());
                    orderDTO.setOrderId(order.getOrderId());
                    orderDTO.setId(order.getId());
                    orderDTO.setTradeId(order.getTradeId());
                    orderDTO.setOrderId(order.getOrderId());

                    orderDTO.setAssayCard(order.getAssayCard());
                    orderDTO.setAssayMobile(order.getAssayMobile());
                    orderDTO.setAssayName(order.getAssayName());


                    orderDTO.setReceiverAddress(order.getReceiverAddress());
                    orderDTO.setReceiverMobile(order.getReceiverMobile());
                    orderDTO.setReceiverName(order.getReceiverName());

                    orderDTOs.add(orderDTO);

                    orderIds.add(order.getId());
                }
            }

            orderXml.updateOrderStatusById(orderIds, YouZanOrderEnum.WAIT_CONFIRM.toString(), new Date());
        }
        logger.info("return success!========={0}", orderDTOs.size());
        return orderDTOs;
    }


    @ResponseBody
    @RequestMapping(value = "/api/orderAuthCallBack.json", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public boolean orderAuthCallBack(@RequestBody List<Integer> ids) {

        logger.info("orderAuthCallBack ids:" + JSON.toJSON(ids).toString());
        if (null != ids && !ids.isEmpty()) {
            int result = orderXml.updateOrderStatusById(ids, YouZanOrderEnum.CONFIRM_SUCCESS.toString(), new Date());

            if (result > 0) {
                return true;
            }
        }
        return false;
    }


    /***
     * 上传物流信息
     *
     * @param logisticsDtoList
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/updateLogistics.json", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public boolean updateLogistics(@RequestBody List<LogisticsDto> logisticsDtoList) {

        logger.info("orderAuthCallBack ids:" + JSON.toJSON(logisticsDtoList).toString());
        if (null != logisticsDtoList && !logisticsDtoList.isEmpty()) {

        }

        return false;
    }


    /**
     * 接收检测报告结果
     *
     * @param reportDTOs
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/DNATestingReport.json", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public boolean insertDNATestingReport(@RequestBody List<DNATestingReportDTO> reportDTOs) {

        List ids = new ArrayList();

        if (null != reportDTOs && !reportDTOs.isEmpty()) {

            if (null != reportDTOs && !reportDTOs.isEmpty()) {
                DNATestingReportDAO reportDAO = null;
                for (DNATestingReportDTO reportDTO : reportDTOs) {
                    if (null != order) {
                        reportDAO = new DNATestingReportDAO();

                        reportDAO.setOrderId(reportDTO.getId());

                        reportDAO.setAssayCard(reportDTO.getAssayCard());

                        reportDAO.setAssayMobile(reportDTO.getAssayMobile());

                        reportDAO.setAssayName(reportDTO.getAssayName());

                        reportDAO.setAssayResult(reportDTO.getAssayResult());

                        reportDAO.setAssayScore(reportDTO.getAssayScore());

                        reportDAO.setAssayDate(reportDTO.getAssayDate());

                        reportDAO.setSpecimenQuality(reportDTO.getSpecimenQuality());

                        reportDAO.setSpecimenType(reportDTO.getSpecimenType());

                        reportDAO.setReportDate(reportDTO.getReportDate());

                        reportDAO.setReviewer(reportDTO.getReviewer());

                        reportDAO.setInspector(reportDTO.getInspector());

                        reportDAO.setGmt_create(new Date());

                        reportDAO.setGmt_modify(new Date());

                        ids.add(reportDTO.getId());

                        report.addAssayReport(reportDAO);
                    }
                }
                orderXml.updateOrderStatusById(ids, YouZanOrderEnum.REPORT.toString(), new Date());
            }
        }
        return true;
    }

    /**
     * 手动从有赞获取订单
     */
    @RequestMapping(value = "/api/manualGetOrder.json", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public boolean manualUpOrder() {

        YZClient client = new DefaultYZClient(new Token(YouZanTokenCache.getToken())); //new Sign(appKey, appSecret)
        YouzanTradesSoldGetParams youzanTradesSoldGetParams = new YouzanTradesSoldGetParams();

        youzanTradesSoldGetParams.setPageSize(20L);
        youzanTradesSoldGetParams.setStatus("WAIT_SELLER_SEND_GOODS");


        YouzanTradesSoldGet youzanTradesSoldGet = new YouzanTradesSoldGet();
        youzanTradesSoldGet.setAPIParams(youzanTradesSoldGetParams);
        YouzanTradesSoldGetResult result = client.invoke(youzanTradesSoldGet);



        return false;
    }

}
