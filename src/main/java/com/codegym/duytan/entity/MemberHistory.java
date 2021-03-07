package com.codegym.duytan.entity;

import com.codegym.duytan.listener.AbstractAuditable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class MemberHistory extends AbstractAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HISTORY_ID")
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID",nullable = false)
    private Member member;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "ADMIN_FLAG")
    private boolean adminFlag;

    @Column(name = "PHONE")
    private String phoneNumber;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "JUSTIFICATION", nullable = false)
    private String justification;

    @Column(name = "USE_FLAG")
    private boolean useFlag;
}
