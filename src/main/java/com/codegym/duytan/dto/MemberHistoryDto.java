package com.codegym.duytan.dto;

import com.codegym.duytan.entity.Member;
import lombok.Data;


@Data
public class MemberHistoryDto {

    private Integer history_id;
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
