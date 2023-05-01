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
    /* UserController 클래스의 인스턴스가 생성될 때, UserService 인터페이스를 구현한 구현체가 주입되어
     userService 멤버 변수에 할당됩니다. 이후 UserController 클래스 내부에서 userService를 이용하여
      다양한 기능을 수행할 수 있게된다.
    */

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
