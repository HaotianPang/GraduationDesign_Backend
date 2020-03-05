package com.ttai.demo.config;

import com.ttai.demo.pojo.ResultEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: cst-sdk-service
 * @description: swagger配置
 * @author: JingXi
 * @create: 2019-08-14 14:05
 * @Copyright © 2019 JingXi. All rights reserved
 **/
@Configuration
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {

        List<ResponseMessage> responseMessageList = new ArrayList<>();
        //将系统错误码枚举类遍历进swagger展示
        for (ResultEnum resultEnum: ResultEnum.values()){
            if (resultEnum.getCode()==0){
                responseMessageList.add(new ResponseMessageBuilder().code(resultEnum.getCode()).message(resultEnum.getMsg()).responseModel(new ModelRef("ResponseResult")).build());
                continue;
            }
            responseMessageList.add(new ResponseMessageBuilder().code(resultEnum.getCode()).message(resultEnum.getMsg()).responseModel(new ModelRef("ApiError")).build());
        }
//        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").responseModel(new ModelRef("ApiError")).build());
//        responseMessageList.add(new ResponseMessageBuilder().code(409).message("业务逻辑异常").responseModel(new ModelRef("ApiError")).build());
//        responseMessageList.add(new ResponseMessageBuilder().code(422).message("参数校验异常").responseModel(new ModelRef("ApiError")).build());
//        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("ApiError")).build());
//        responseMessageList.add(new ResponseMessageBuilder().code(503).message("Hystrix异常").responseModel(new ModelRef("ApiError")).build());



        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                //不使用默认的响应码
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ttai.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("后端通用框架")
                .description("通用框架")
                .termsOfServiceUrl("https://zzjing.top/")
                .version("1.0.0")
                .build();
    }
}
