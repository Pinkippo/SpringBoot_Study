package com.example.practice.Data.DTO;

import lombok.Getter;

@Getter
public class UserResponseDTO {
    private Long id;
    private String name;

    // 생성자
    public UserResponseDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
