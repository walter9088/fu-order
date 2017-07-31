package com.fu.order.dto;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by walter on 17/7/23.
 */
public class JsonTest {

    public static  void xxx(String[] args){

        MsgPushEntity entity = new MsgPushEntity();
        entity.setMode(1);
        entity.setMsg("%7B%22trade%22:%7B%22num%22:2,%22goods_kind%22:2");
        entity.setApp_id("safsa");
        entity.setClient_id("dsfda");
        entity.setKdt_name("dsaf");
        System.out.print(JSONObject.toJSON(entity).toString());
    }
}