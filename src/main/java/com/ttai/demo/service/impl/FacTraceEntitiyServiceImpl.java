package com.ttai.demo.service.impl;

import com.ttai.demo.entity.FacTraceEntitiy;
import com.ttai.demo.pojo.dto.IdDTO;
import com.ttai.demo.utils.Constant;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ttai.demo.mapper.FacTraceEntitiyMapper;
import com.ttai.demo.service.FacTraceEntitiyService;
import tk.mybatis.mapper.entity.Example;

@Service
public class FacTraceEntitiyServiceImpl implements FacTraceEntitiyService{

    @Resource
    private FacTraceEntitiyMapper facTraceEntitiyMapper;

    @Override
    public boolean insertData(FacTraceEntitiy entitiy) {
        facTraceEntitiyMapper.insert(entitiy);
        return true;
    }

    @Override
    public FacTraceEntitiy findById(IdDTO dto) {
        Example example=new Example(FacTraceEntitiy.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andCondition(Constant.DB_FAC_ID+Constant.CONDITION_EQUAL,dto.getId());
        FacTraceEntitiy entitiy=facTraceEntitiyMapper.selectOneByExample(example);
        return entitiy;
    }
}
