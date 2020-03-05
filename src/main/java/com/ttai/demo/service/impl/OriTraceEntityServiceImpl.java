package com.ttai.demo.service.impl;

import com.ttai.demo.entity.OriTraceEntity;
import com.ttai.demo.pojo.dto.IdDTO;
import com.ttai.demo.utils.Constant;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ttai.demo.mapper.OriTraceEntityMapper;
import com.ttai.demo.service.OriTraceEntityService;
import tk.mybatis.mapper.entity.Example;

@Service
public class OriTraceEntityServiceImpl implements OriTraceEntityService{

    @Resource
    private OriTraceEntityMapper oriTraceEntityMapper;

    @Override
    public boolean insertData(OriTraceEntity entity) {
        oriTraceEntityMapper.insert(entity);
        return true;
    }

    @Override
    public OriTraceEntity findById(IdDTO dto) {
        Example example=new Example(OriTraceEntity.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andCondition(Constant.DB_ORI_ID+ Constant.CONDITION_EQUAL,dto.getId());
        OriTraceEntity entity=oriTraceEntityMapper.selectOneByExample(example);
        return entity;
    }
}
