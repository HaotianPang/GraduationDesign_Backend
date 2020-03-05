package com.ttai.demo.service;

import com.ttai.demo.entity.User;
import com.ttai.demo.pojo.dto.UserRegister;

public interface UserService{

    boolean insertUser(User user);

    User getIdByPhone(String phoneNumber);

//    boolean isExist(User user);




}
