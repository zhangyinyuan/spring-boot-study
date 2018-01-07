package com.yuan.ngu.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;


@Api(value = "Redis Session", description = "将session托管到redis中,该类提供测试方法")
@RestController
@RequestMapping("/redis")
public class RedisSessionController {

    @ApiOperation(value = "获取用户的id", notes = "通过用户名获取用户的id")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "username", defaultValue = "u1101", value = "用户名", dataType = "string", required = true)
    })
    @RequestMapping(value = "/getUid/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object getUid(HttpSession session, @PathVariable String username) {
        UUID uid = (UUID) session.getAttribute(username);
        if (null == uid) {
            uid = UUID.randomUUID();
        }
        session.setAttribute(username, uid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(username,uid);
        return jsonObject;
    }
}
