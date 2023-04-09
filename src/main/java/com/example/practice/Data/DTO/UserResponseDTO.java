package com.example.practice.Data.DTO;

import lombok.Getter;

@Getter // GETTER 메서드 추가
public class UserResponseDTO {
    private Long id;
    private String name;

    public UserResponseDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
