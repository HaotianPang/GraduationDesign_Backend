package com.ttai.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.Gson;
import lombok.Data;

@Data
@Table(name = "fac_trace_entitiy")
public class FacTraceEntitiy implements Serializable {
    /**
     * 加工批号
     */
    @Id
    @Column(name = "fact_number")
    private String factNumber;

    /**
     * 加工方式
     */
    @Column(name = "factory_method")
    private String factoryMethod;

    /**
     * 制单人
     */
    @Column(name = "signiture")
    private String signiture;

    /**
     * 制单日期
     */
    @Column(name = "list_date")
    private String listDate;

    /**
     * 产品名称
     */
    @Column(name = "produciton_name")
    private String producitonName;

    /**
     * 执行标准
     */
    @Column(name = "excutes_stander")
    private String excutesStander;

    /**
     * 加工企业名称
     */
    @Column(name = "facotryname")
    private String facotryname;

    /**
     * 加工企业编号
     */
    @Column(name = "factory_number")
    private String factoryNumber;

    /**
     * 生产许可编号
     */
    @Column(name = "licence_number")
    private String licenceNumber;

    /**
     * 加工类型
     */
    @Column(name = "factory_class")
    private String factoryClass;

    /**
     * 鱼源基地编号
     */
    @Column(name = "origin_number")
    private String originNumber;

    /**
     * 规格
     */
    @Column(name = "`size`")
    private String size;

    private static final long serialVersionUID = 1L;

    public static void main(String [] args){
        FacTraceEntitiy entitiy=new FacTraceEntitiy();
        entitiy.setExcutesStander("345dfg3467");
        entitiy.setFacotryname("66gtfde");
        entitiy.setFactNumber("3673423ff");
        entitiy.setFactoryNumber("362345134sdf");
        entitiy.setFactoryClass("34sdfyq345");
        entitiy.setFactoryMethod("低温");
        entitiy.setListDate("12423");
        entitiy.setSigniture("32srttr234");
        entitiy.setProducitonName("3regf");
        entitiy.setLicenceNumber("dfert432534146y");
        entitiy.setOriginNumber("234dsf236");
        entitiy.setSize("3-4两");
        String data=new Gson().toJson(entitiy);
        System.out.println(data);

    }

}