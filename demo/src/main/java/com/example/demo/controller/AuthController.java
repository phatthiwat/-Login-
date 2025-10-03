package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // คืนค่าเป็นชื่อไฟล์ HTML (ไม่ต้องมี .html)
    }
}