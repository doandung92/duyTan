package com.codegym.duytan.entity;


import com.codegym.duytan.listener.AuditListener;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class Member extends AuditListener<String> {

    // Xem lại document về các trường
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer member_id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String image;

    private boolean admin_flag;

    private String phone;

    private String password;

    private boolean use_flag = true;

}
