package com.codegym.duytan.service.Interface;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.model.MemberListModel;

import java.util.List;

public interface IMemberService extends IService<MemberDto,Integer> {
    List<MemberDto> findActiveMembersOnly();
    List<MemberListModel> buildListMemberModel();
}
