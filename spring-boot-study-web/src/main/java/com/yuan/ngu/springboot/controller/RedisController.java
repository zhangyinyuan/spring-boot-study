package com.yuan.ngu.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.yuan.ngu.springboot.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Reference(version = "1.0.0")
    RedisService redisService;

    @RequestMapping(value = "/get/{key}",method = RequestMethod.GET)
    @ResponseBody
    public Object get(@PathVariable String key) {
        String redisValue = (String) redisService.opsForValue(key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value",redisValue);
        jsonObject.put("key",key);
        return jsonObject;
    }
}
