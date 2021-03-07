package com.codegym.duytan.entity;

import com.codegym.duytan.listener.AbstractAuditable;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Member extends AbstractAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Integer memberId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL",unique = true, nullable = false)
    private String email;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "ADMIN_FLAG", nullable = false)
    private boolean adminFlag = false;

    @Column(name = "PHONE")
    private String phoneNumber;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "USE_FLAG")
    private boolean useFlag = true;

}
