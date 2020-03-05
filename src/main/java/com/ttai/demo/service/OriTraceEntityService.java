package com.ttai.demo.service;

import com.ttai.demo.entity.OriTraceEntity;
import com.ttai.demo.pojo.dto.IdDTO;

public interface OriTraceEntityService{
    boolean insertData(OriTraceEntity entity);
    OriTraceEntity findById(IdDTO dto);


}
