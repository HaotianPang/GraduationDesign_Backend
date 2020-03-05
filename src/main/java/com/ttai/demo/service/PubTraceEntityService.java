package com.ttai.demo.service;

import com.ttai.demo.entity.OriTraceEntity;
import com.ttai.demo.entity.PubTraceEntity;
import com.ttai.demo.pojo.dto.IdDTO;

public interface PubTraceEntityService{
    boolean insertData(PubTraceEntity entity);
    PubTraceEntity findById(IdDTO dto);

}
