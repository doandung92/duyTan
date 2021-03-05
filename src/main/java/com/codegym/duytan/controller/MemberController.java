package com.codegym.duytan.controller;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.entity.Member;
import com.codegym.duytan.service.Interface.IMemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class MemberController {

    @Autowired
    private IMemberService memberService;

//    @RequestMapping("/member-list")
//    public String MainLayout(Model model){
//        List<MemberDto> members = memberService.findAll();
//        model.addAttribute("memberList",members);
//        return
//    }
}
