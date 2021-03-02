package com.codegym.duytan.controller;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
