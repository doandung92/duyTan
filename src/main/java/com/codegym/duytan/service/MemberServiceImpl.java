package com.codegym.duytan.service;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.entity.Member;
import com.codegym.duytan.model.MemberListTableModel;
import com.codegym.duytan.repository.MemberRepository;
import com.codegym.duytan.service.Interface.IMemberService;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<MemberListTableModel> buildMemberListTableModel() {
        List<Member> members = memberRepository.findAll();
        return mapper.mapAsList(members,MemberListTableModel.class);
    }
}
