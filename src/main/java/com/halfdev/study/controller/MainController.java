package com.halfdev.study.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
//@RequiredArgsConstructor // 초기화 되지 않은 final 필드와 @NonNull annotation이 붙은 필드만 생성자 생성
@Controller
public class MainController {

    @GetMapping("/hello")
    public String main() {
        return "hello";
    }

    @GetMapping("/my")
    public String my(){
        return "my";
    }

}
