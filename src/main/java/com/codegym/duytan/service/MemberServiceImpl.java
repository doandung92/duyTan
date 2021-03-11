package com.codegym.duytan.service;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.entity.Member;
import com.codegym.duytan.model.MemberListModel;
import com.codegym.duytan.repository.MemberRepository;
import com.codegym.duytan.service.Interface.IMemberService;
import com.codegym.duytan.service.specification.MemberQuery;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class MemberServiceImpl implements IMemberService {

    private final MemberRepository memberRepository;
    private final MapperFacade mapper;
    private final MemberQuery memberQuery;


    @Override
    public List<MemberDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return mapper.mapAsList(members,MemberDto.class);
    }

    @Override
    public Optional<MemberDto> findById(Integer id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.map(m -> mapper.map(m,MemberDto.class));
    }

    @Override
    public void remove(MemberDto memberDto) {
        Member member = mapper.map(memberDto,Member.class);
        memberRepository.delete(member);
    }

    @Override
    public MemberDto save(MemberDto memberDto) {
        Member member = mapper.map(memberDto,Member.class);
        memberRepository.save(member);
        return mapper.map(member,MemberDto.class);
    }

    @Override
    public List<MemberDto> findActiveMembersOnly() {
        return mapper.mapAsList(memberRepository.findAll(memberQuery.findActiveMembers()),MemberDto.class);
    }

    @Override
    public List<MemberListModel> buildListMemberModel() {
        List<Member> members = memberRepository.findAll();
        return mapper.mapAsList(members, MemberListModel.class);
    }
}
