package com.example.practice.Data.DTO;

import lombok.Getter;

@Getter
public class UserResponseDTO {
    private Long id;
    private String name;

    // (7) 해당 로직 간단하게 설명
    public UserResponseDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
