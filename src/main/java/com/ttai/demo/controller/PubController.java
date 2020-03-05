package com.ttai.demo.controller;

import com.google.gson.Gson;
import com.ttai.demo.entity.PubTraceEntity;
import com.ttai.demo.pojo.ResponseResult;
import com.ttai.demo.pojo.ResultEnum;
import com.ttai.demo.pojo.dto.IdDTO;
import com.ttai.demo.service.PubTraceEntityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pubtrace")
public class PubController implements CoreFunction {

    private final PubTraceEntityService service;
    public PubController(PubTraceEntityService service){
        this.service=service;
    }

    @Override
    @PostMapping(value = "search")
    public ResponseResult searchById(String id) {
        IdDTO dto=new IdDTO();
        dto.setId(id);
        PubTraceEntity entity= service.findById(dto);
        return new ResponseResult(ResultEnum.SUCCESS,entity);
    }

    @Override
    public ResponseResult insertEntity(String data) {
        Gson gson=new Gson();
        PubTraceEntity entity=gson.fromJson(data,PubTraceEntity.class);
        service.insertData(entity);
        return new ResponseResult(ResultEnum.SUCCESS);

    }
}
