package com.ttai.demo.controller;

import com.google.gson.Gson;
import com.ttai.demo.entity.OriTraceEntity;
import com.ttai.demo.pojo.ResponseResult;
import com.ttai.demo.pojo.ResultEnum;
import com.ttai.demo.pojo.dto.IdDTO;
import com.ttai.demo.service.OriTraceEntityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "oritrace")
public class OriController implements CoreFunction {
    private final OriTraceEntityService service;

    public OriController(OriTraceEntityService service) {
        this.service = service;
    }

    @PostMapping(value = "search")
    public ResponseResult searchById(@RequestParam("id")String id){
        IdDTO dto=new IdDTO();
        dto.setId(id);
        OriTraceEntity entity=service.findById(dto);
        return new ResponseResult(ResultEnum.SUCCESS,entity);
    }
    @PostMapping(value = "insert")
    public ResponseResult insertEntity(@RequestParam("data") String data){
        Gson gson=new Gson();
        OriTraceEntity entity=gson.fromJson(data,OriTraceEntity.class);
        service.insertData(entity);
        return new ResponseResult(ResultEnum.SUCCESS);
    }
}