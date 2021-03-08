package com.codegym.duytan.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberListTableModel {
    private Integer memberId;
    private String name;
    private String email;
    private String image;
    private boolean adminFlag;
    private String phoneNumber;
    private String password;
    private boolean userFlag = true;
}
