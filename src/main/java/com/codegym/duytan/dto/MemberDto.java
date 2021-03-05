package com.codegym.duytan.dto;

import lombok.Data;

@Data
public class MemberDto {

    private Integer member_id;
    private String name;
    private String email;
    private String image;
    private boolean admin_flag;
    private String phone;
    private String password;
    private boolean user_flag;
}
