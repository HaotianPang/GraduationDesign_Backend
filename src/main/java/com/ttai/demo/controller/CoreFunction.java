package com.ttai.demo.controller;

import com.ttai.demo.pojo.ResponseResult;
import com.ttai.demo.pojo.dto.IdDTO;

public interface CoreFunction {

    ResponseResult searchById(String id);
    ResponseResult insertEntity(String data);
}
