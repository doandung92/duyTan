package com.codegym.duytan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

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

    private boolean user_flag = true;

}
