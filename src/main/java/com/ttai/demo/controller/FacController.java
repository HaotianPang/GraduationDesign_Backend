package com.ttai.demo.controller;

import com.google.gson.Gson;
import com.ttai.demo.entity.FacTraceEntitiy;
import com.ttai.demo.pojo.ResponseResult;
import com.ttai.demo.pojo.ResultEnum;
import com.ttai.demo.pojo.dto.IdDTO;
import com.ttai.demo.service.FacTraceEntitiyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "factrace")
public class FacController implements CoreFunction{
    private final FacTraceEntitiyService facService;

    public FacController(FacTraceEntitiyService service){
        this.facService=service;
    }

    @PostMapping(value = "search")
    public ResponseResult searchById(@RequestParam("id") String id){
        IdDTO dto=new IdDTO();
        dto.setId(id);
        FacTraceEntitiy entitiy=facService.findById(dto);
        Gson gson = new Gson();
        String data=gson.toJson(entitiy);
        return new ResponseResult(ResultEnum.SUCCESS,data);
    }

    @PostMapping(value = "insert")
    public ResponseResult insertEntity(@RequestParam("data")String data){
        Gson gson=new Gson();
        FacTraceEntitiy entitiy=gson.fromJson(data,FacTraceEntitiy.class);
        facService.insertData(entitiy);
        return new ResponseResult(ResultEnum.SUCCESS);
    }

}
