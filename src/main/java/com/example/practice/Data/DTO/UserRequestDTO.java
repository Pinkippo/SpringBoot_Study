package com.example.practice.Data.DTO;

import com.example.practice.Data.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //  (4) 해당 어노테이션의 역할 주석으로 작성
@NoArgsConstructor  // (5) 해당 어노테이션의 역할 주석으로 작성
@AllArgsConstructor
public class UserRequestDTO {
    private String name;

    // (6) 해당 로직 간단하게 설명
    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .build();
    }

}
