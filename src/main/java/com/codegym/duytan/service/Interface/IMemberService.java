package com.codegym.duytan.service.Interface;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.entity.Member;
import com.codegym.duytan.model.MemberListTableModel;

import java.util.List;

public interface IMemberService extends IService<MemberDto,Integer> {

    List<MemberListTableModel> buildMemberListTableModel();
}
