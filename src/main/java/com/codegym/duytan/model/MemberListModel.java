package com.codegym.duytan.model;

import com.codegym.duytan.constant.UseFlag;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberListModel {

    private Integer memberId;
    private String name;
    private String email;
    private String image;
    private boolean adminFlag;
    private String phoneNumber;
    private String password;
    private String useFlag = UseFlag.Y;
}
