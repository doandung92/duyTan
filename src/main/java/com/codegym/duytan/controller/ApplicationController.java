package com.codegym.duytan.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
public class ApplicationController {

    @GetMapping
    public String index() {
        return "index";
    }

}
