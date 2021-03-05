package com.codegym.duytan.controller;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.entity.Member;
import com.codegym.duytan.service.Interface.IMemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {

//    @Autowired
//    private IMemberService memberService;
    // Có thể dùng kết hợp với @AllArgsConstructor cho đẹp code. K cần dùng Autowire
    private final IMemberService memberService;

    // Chưa validate đầu vào. Chưa xử lý response form không hợp lệ
    @PostMapping
    public MemberDto createMember(@RequestBody MemberDto memberDto){
       return memberService.save(memberDto);
    }

//    @RequestMapping("/member-list")
//    public String MainLayout(Model model){
//        List<MemberDto> members = memberService.findAll();
//        model.addAttribute("memberList",members);
//        return
//    }
}
