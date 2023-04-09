package com.example.practice.Controller;

import com.example.practice.Data.DTO.UserRequestDTO;
import com.example.practice.Data.DTO.UserResponseDTO;
import com.example.practice.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/save")  // 유저 회원가입
    public void UserSave(UserRequestDTO userRequestDTO){
        userService.SaveUser(userRequestDTO);
    }

    @GetMapping("select") // 유저 정보 확인
    public UserResponseDTO UserSelectById(Long id){
        return userService.SelectUserById(id);
    }
}
