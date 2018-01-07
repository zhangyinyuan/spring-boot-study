package com.yuan.ngu.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.yuan.ngu.springboot.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@Api(value = "Redis测试接口", description = "仅仅用来测试，没有其他用途")
public class RedisController {

    @Reference(version = "1.0.0")
    RedisService redisService;

    @ApiOperation(value = "获取Redis", notes = "用来测试Redis")
    @ApiImplicitParam(paramType = "path", name = "key", defaultValue = "dashabi", value = "Redis 的 key", required = true, dataType = "string")
    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object get(@PathVariable String key) {
        String redisValue = redisService.getStr(key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value", redisValue);
        jsonObject.put("key", key);
        return jsonObject;
    }

    @ApiOperation(value = "redis中写入字符串", notes = "redis中写入字符串")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "string", name = "key", value = "Redis key", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "string", name = "value", value = "Redis  string value", required = true)
    })
    @RequestMapping(value = "/set/{key}/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object set(@PathVariable String key,@PathVariable String value) {
        redisService.setStr(key,value);
        String redisValue = redisService.getStr(key);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value", redisValue);
        jsonObject.put("key", key);
        return jsonObject;
    }
}
