package com.ttai.demo.service.asyncservice;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: dc-platform
 * @description: 异步方法
 * @author: JingXi
 * @create: 2019-09-14 19:38
 * @Copyright © 2019 JingXi. All rights reserved
 **/
@Service
public class AsyncService {
    @Async
    public void createSystemMessage(){
        System.out.println("异步操作");
    }
}

