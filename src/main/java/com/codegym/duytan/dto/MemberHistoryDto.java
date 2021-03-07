package com.codegym.duytan.dto;

import com.codegym.duytan.entity.Member;
import lombok.Data;


@Data
public class MemberHistoryDto {

    private Integer historyId;
    private Member member;
    private String name;
    private String email;
    private String image;
    private boolean adminFlag;
    private String phoneNumber;
    private String password;
    private String justification;
    private boolean useFlag;
}
