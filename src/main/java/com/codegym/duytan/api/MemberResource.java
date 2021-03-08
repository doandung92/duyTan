package com.codegym.duytan.api;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.model.MemberListTableModel;
import com.codegym.duytan.service.Interface.IMemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/members")
@AllArgsConstructor
public class MemberResource {

    private final IMemberService memberService;

    @GetMapping("/datatables")
    public List<MemberListTableModel> getAllMembers(){
        return memberService.buildMemberListTableModel();
    }
}
