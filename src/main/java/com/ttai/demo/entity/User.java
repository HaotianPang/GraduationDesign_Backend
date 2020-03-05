package com.ttai.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`user`")
public class User implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * phoneNumber
     */
    @Column(name = "phoneNumber")
    private String phonenumber;

    /**
     * password
     */
    @Column(name = "`password`")
    private String password;



    private static final long serialVersionUID = 1L;
}