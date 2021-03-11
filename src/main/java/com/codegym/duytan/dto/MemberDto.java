package com.codegym.duytan.dto;

import com.codegym.duytan.constant.UseFlag;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDto {

    private Integer memberId;
    private String name;
    private String email;
    private String image;
    private boolean adminFlag;
    private String phoneNumber;
    private String password;
    private String useFlag = UseFlag.Y;
}
