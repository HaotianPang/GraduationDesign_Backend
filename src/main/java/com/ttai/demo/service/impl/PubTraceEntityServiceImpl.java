package com.ttai.demo.service.impl;

import com.ttai.demo.entity.PubTraceEntity;
import com.ttai.demo.pojo.dto.IdDTO;
import com.ttai.demo.utils.Constant;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ttai.demo.mapper.PubTraceEntityMapper;
import com.ttai.demo.service.PubTraceEntityService;
import tk.mybatis.mapper.entity.Example;

@Service
public class PubTraceEntityServiceImpl implements PubTraceEntityService{

    @Resource
    private PubTraceEntityMapper pubTraceEntityMapper;

    @Override
    public boolean insertData(PubTraceEntity entity) {
        pubTraceEntityMapper.insert(entity);
        return true;
    }

    @Override
    public PubTraceEntity findById(IdDTO dto) {
        Example example=new Example(PubTraceEntity.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andCondition(Constant.DB_PUB_ID+ Constant.CONDITION_EQUAL,dto.getId());
        return pubTraceEntityMapper.selectOneByExample(example);

    }
}
