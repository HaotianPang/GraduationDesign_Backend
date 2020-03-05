package com.ttai.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "ori_trace_entity")
public class OriTraceEntity implements Serializable {
    /**
     * 原料编号
     */
    @Id
    @Column(name = "ori_number")
    private String oriNumber;

    /**
     * 供货品种
     */
    @Column(name = "species_name")
    private String speciesName;

    /**
     * 鱼源基地名称
     */
    @Column(name = "ori_base_name")
    private String oriBaseName;

    /**
     * 鱼源基地编号
     */
    @Column(name = "ori_base_number")
    private String oriBaseNumber;

    /**
     * 养殖批号
     */
    @Column(name = "feed_batch")
    private String feedBatch;

    /**
     * 养殖池塘
     */
    @Column(name = "pond_number")
    private String pondNumber;

    /**
     * 供货重量
     */
    @Column(name = "weight")
    private Integer weight;

    /**
     * 供货数量
     */
    @Column(name = "`count`")
    private Integer count;

    /**
     * 规格
     */
    @Column(name = "`size`")
    private String size;

    /**
     * 捕捞日期
     */
    @Column(name = "harvest_date")
    private String harvestDate;

    /**
     * 交货日期
     */
    @Column(name = "deliver_data")
    private String deliverData;

    /**
     * 基地电话
     */
    @Column(name = "base_phone_number")
    private String basePhoneNumber;

    private static final long serialVersionUID = 1L;
}