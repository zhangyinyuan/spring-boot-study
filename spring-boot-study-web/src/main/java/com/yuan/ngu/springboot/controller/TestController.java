package com.yuan.ngu.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试类", description = "一般的测试类")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "测试异常统一处理", notes = "测试异常统一处理")
    @RequestMapping(path = "/testException",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object testException() {
        String str = null;
        return str.toString();
    }

}
