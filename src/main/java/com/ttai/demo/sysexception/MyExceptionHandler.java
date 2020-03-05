package com.ttai.demo.sysexception;

import com.ttai.demo.pojo.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: taisecurity
 * @description:
 * @author: JingXi
 * @create: 2019-04-02 14:01
 * @Copyright © 2019 JingXi. All rights reserved
 **/
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(BackendException.class)
    public ResponseResult handleException(BackendException e) {
        e.printStackTrace();
        return new ResponseResult<>(e.getCode(), e.getMessage());
    }

    /**
     * 其它错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleAuthorizationException(Exception e) {
        e.printStackTrace();
        return new ResponseResult<>(-1,e.getMessage());
    }
}

