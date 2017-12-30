package com.yuan.ngu.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorController {


    @RequestMapping(path = "/monitor")
    @ResponseBody
    public Object monitor() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result","success");
        return jsonObject;
    }
}
