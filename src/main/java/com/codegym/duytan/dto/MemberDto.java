package com.codegym.duytan.dto;

import lombok.Data;

@Data
public class MemberDto {

    private Integer memberId;
    private String name;
    private String email;
    private String image;
    private boolean adminFlag;
    private String phoneNumber;
    private String password;
    private boolean userFlag;
}
