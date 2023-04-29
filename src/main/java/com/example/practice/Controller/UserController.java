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
    // (3)

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // (3) 해당 로직 간단하게 설명
    
    @GetMapping("/save")
    public void UserSave(String name){
        UserRequestDTO user = new UserRequestDTO(name);
        userService.SaveUser(user);
    }

    @GetMapping("select")
    public UserResponseDTO UserSelectById(Long id){
        return userService.SelectUserById(id);
    }
}
