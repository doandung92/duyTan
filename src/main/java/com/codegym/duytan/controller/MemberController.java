package com.codegym.duytan.controller;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.entity.Member;
import com.codegym.duytan.service.Interface.IMemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {

    private final IMemberService memberService;

//    @PostMapping
//    public MemberDto createMember(@RequestBody MemberDto memberDto){
//       return memberService.save(memberDto);
//    }

    @GetMapping("")
    public String index() {
        return "pages/member/member-list";
    }

}
