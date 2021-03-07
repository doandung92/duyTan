package com.codegym.duytan.controller;

import com.codegym.duytan.dto.*;
import com.codegym.duytan.service.Interface.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {
    private final IMemberService memberService;

    @PostMapping
    public MemberDto createMember(@RequestBody MemberDto memberDto){
       return memberService.save(memberDto);
    }

}
