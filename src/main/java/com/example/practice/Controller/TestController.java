package com.example.practice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스가 RESTful 웹 서비스의 엔드포인트로 사용될 수 있도록 지정
@RequestMapping(value = "/test/v1") // 특정 URL 요청에 대해 처리할 메서드를 지정할 수 있다
public class TestController {

    @GetMapping("/text")
    public String test_text(){
        return "test";
    }
}
