package com.ttai.demo.service;

import com.ttai.demo.entity.FacTraceEntitiy;
import com.ttai.demo.pojo.dto.IdDTO;

public interface FacTraceEntitiyService{
    boolean insertData(FacTraceEntitiy entitiy);
    FacTraceEntitiy findById(IdDTO dto);
}
