package com.codegym.duytan.dto;

import lombok.Data;

@Data
public class MemberDto {

    // Xem lại convention đặt tên của Java. Cách tên này là của JS

    private Integer member_id;
    private String name;
    private String email;
    private String image;
    private boolean admin_flag;
    private String phone;
    private String password;
    private boolean user_flag;
}
