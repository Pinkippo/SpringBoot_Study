package com.example.practice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // (1) 해당 어노테이션의 역할 주석으로 작성
@RequestMapping(value = "/test/v1") // (2) 해당 어노테이션의 역할 주석으로 작성
public class TestController {

    @GetMapping("/text")
    public String test_text(){
        return "test";
    }
}
