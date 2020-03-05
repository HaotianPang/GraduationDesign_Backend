package com.ttai.demo.service.impl;

import com.ttai.demo.entity.User;
import com.ttai.demo.utils.Constant;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ttai.demo.mapper.UserMapper;
import com.ttai.demo.service.UserService;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insertUser(User user) {
        if(user==null){
            return false;
        }
        userMapper.insert(user);
        return true;
    }


    @Override
    public User getIdByPhone(String phoneNumber) {
        if(phoneNumber.equals("")||phoneNumber==null){
            return null;
        }
        Example example=new Example(User.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andCondition(Constant.DB_USER_NUMBER+Constant.CONDITION_EQUAL,phoneNumber);
        User user=userMapper.selectOneByExample(example);
        return user;
    }

//    @Override
//    public boolean isExist(User user) {
//        boolean exist=userMapper.existsWithPrimaryKey(user);
//        return exist;
//
//    }

}
