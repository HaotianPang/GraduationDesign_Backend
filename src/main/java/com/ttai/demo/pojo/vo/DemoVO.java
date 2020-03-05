package com.ttai.demo.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author JingXi
 * @program springboot通用模版
 * @description
 * @create 2020/2/17 15:22
 * @copyright © 2018 JingXi. All rights reserved
 **/
@Data
public class DemoVO {

    @ApiModelProperty(value = "编号")
    private Integer id;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "电话号码")
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
