package com.ttai.demo.controller;

import com.ttai.demo.pojo.ResponseResult;
import com.ttai.demo.pojo.ResultEnum;
import com.ttai.demo.sysexception.BackendException;
import com.ttai.demo.utils.EnumUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: dc-platform
 * @description: 用户逻辑
 * @author: JingXi
 * @create: 2019-08-27 20:58
 * @Copyright © 2019 JingXi. All rights reserved
 **/
@Api(value = "errorCode", tags = "错误码查询")
@RestController
@Slf4j
@RequestMapping(value = "errorCode")
public class CodeErrorController {


    @ApiOperation(value = "错误码查询", notes = "输入错误码即可得到错误码的解释",response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "请求参数，示例：0")
    })
    @PostMapping(value = "getCodeImplication")
    public ResponseResult createNewUser(@RequestParam("code") Integer code){
        if (code == 110){
            throw new RuntimeException("hello world");
        }else if (code ==120){
            throw new  BackendException(ResultEnum.COMMON_PARAM_EMPTY);
        }
        String msg = EnumUtil.getByCode(code, ResultEnum.class);
        return new ResponseResult<>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),msg);
    }

}

