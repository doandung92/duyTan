package com.codegym.duytan.entity;

import com.codegym.duytan.listener.AuditListener;
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
public class MemberHistory extends AuditListener<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer history_id;

    @ManyToOne
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    private String name;

    private String email;

    private String image;

    private boolean admin_flag;

    private String phone;

    private String password;

    private String justification;

    private boolean use_flag;
}
