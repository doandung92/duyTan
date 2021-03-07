package com.codegym.duytan.service;

import com.codegym.duytan.dto.MemberHistoryDto;
import com.codegym.duytan.entity.MemberHistory;
import com.codegym.duytan.repository.MemberHistoryRepository;
import com.codegym.duytan.service.Interface.IMemberHistoryService;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class MemberHistoryServiceImpl implements IMemberHistoryService {

    private final MemberHistoryRepository memberHistoryRepository;
    private final MapperFacade mapper;

    @Override
    public List<MemberHistoryDto> findAll() {
        List<MemberHistory> memberHistoryList = memberHistoryRepository.findAll();
        return mapper.mapAsList(memberHistoryList, MemberHistoryDto.class);
    }

    @Override
    public Optional<MemberHistoryDto> findById(Integer id) {
        Optional<MemberHistory> memberHistory = memberHistoryRepository.findById(id);
        return memberHistory.map(m -> mapper.map(m,MemberHistoryDto.class));
    }

    @Override
    public void remove(MemberHistoryDto memberHistoryDto) {
        MemberHistory memberHistory = mapper.map(memberHistoryDto,MemberHistory.class);
        memberHistoryRepository.delete(memberHistory);
    }

    @Override
    public MemberHistoryDto save(MemberHistoryDto memberHistoryDto) {
        MemberHistory memberHistory = mapper.map(memberHistoryDto,MemberHistory.class);
        memberHistoryRepository.save(memberHistory);
        return mapper.map(memberHistory,MemberHistoryDto.class);
    }
}
