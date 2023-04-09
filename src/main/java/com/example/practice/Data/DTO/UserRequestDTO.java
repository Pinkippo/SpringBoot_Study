package com.example.practice.Data.DTO;

import com.example.practice.Data.Entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // GETTER 메서드 추가
@NoArgsConstructor // 기본 생성자 추가
public class UserRequestDTO {
    private Long id;
    private String name;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .id(id)
                .name(name)
                .build();
    }

}
