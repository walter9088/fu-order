package com.fu.order.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fu.order.dto.MsgEntity;
import com.fu.order.dto.MsgPushEntity;
import com.fu.order.youzan.DNATestingOrderFromYouZan;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by walter on 17/7/23.
 */
@Controller
public class OrderStatusUpdateMsgController {

//    private static final int mode = 1 ; //服务商
//    private static final String clientId="TEST"; //服务商的秘钥证书
//    private static final String clientSecret="TEST";//服务商的秘钥证书

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(OrderStatusUpdateMsgController.class);

    @Autowired
    private DNATestingOrderFromYouZan dnaTestingOrderFromYouZan;


    @ResponseBody
    @RequestMapping(value = "/api/orderStatusMsg.json", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public Object test(@RequestBody MsgPushEntity entity) {

        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("msg", "success");

        /**
         *  判断是否为心跳检查消息
         *  1.是则直接返回
         */
        if (entity.isTest()) {
            return res;
        }


//        /**
//         * 判断消息是否合法
//         * 解析sign
//         * MD5 工具类开发者可以自行引入
//         */
//        String sign= MD5.digest(clientId+entity.getMsg()+clientSecret);
//        if (!sign.equals(entity.getSign())){
//            return res;
//        }

        /**
         * 对于msg 先进行URI解码
         */
        // String msg = "";
        try {
            if ("TRADE".equals(entity.getType())) {
            String msg = URLDecoder.decode(entity.getMsg(), "utf-8");
            JSONObject obj = JSONObject.parseObject(msg);

            MsgEntity entity1 =(MsgEntity) JSONObject.toJavaObject(obj,MsgEntity.class);

            dnaTestingOrderFromYouZan.getDNATestingOrderFromYouZan( entity1.getTrade());
            }
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

        /**
         * 返回结果
         */
        return res;
    }

}

