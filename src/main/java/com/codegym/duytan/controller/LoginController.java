package com.codegym.duytan.controller;

import com.codegym.duytan.config.security.MyUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/test")
    public String index(Authentication authentication){
        if (authentication.getPrincipal() instanceof MyUserDetail) {
            MyUserDetail user = (MyUserDetail) authentication.getPrincipal();
            System.out.println(user.getUsername());
            System.out.println(user.getAuthorities());
        }
        return "index";
    }
}
