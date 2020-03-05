package com.ttai.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pub_trace_entity")
public class PubTraceEntity implements Serializable {
    /**
     * traceCode
     */
    @Id
    @Column(name = "trace_code")
    private String traceCode;

    /**
     * processingMethod
     */
    @Column(name = "processing_method")
    private String processingMethod;

    /**
     * productionName
     */
    @Column(name = "production_name")
    private String productionName;

    /**
     * batchNumber
     */
    @Column(name = "batch_number")
    private String batchNumber;

    /**
     * feedingBase
     */
    @Column(name = "feeding_base")
    private String feedingBase;

    /**
     * companyCode
     */
    @Column(name = "company_code")
    private String companyCode;

    /**
     * companyName
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * factoryBatch
     */
    @Column(name = "factory_batch")
    private String factoryBatch;

    /**
     * productionDate
     */
    @Column(name = "production_date")
    private String productionDate;

    /**
     * shelfLife
     */
    @Column(name = "shelf_life")
    private String shelfLife;

    /**
     * storeCondition
     */
    @Column(name = "store_condition")
    private String storeCondition;

    private static final long serialVersionUID = 1L;
}