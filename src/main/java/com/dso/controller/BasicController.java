package com.dso.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log
public class BasicController {
    @GetMapping("/")
    public String index() {
        return "/admin/main";
    }

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/admin/main")
    public void main() {
        log.info("자, 이제 시작이야.");
    }
}
