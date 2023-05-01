package com.example.practice.Data.DTO;

import com.example.practice.Data.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //  getter 메소드 자동 생성
@NoArgsConstructor  // 인자를 받지 않는 기본 생성자를 자동으로 생성해주는 기능을 제공
@AllArgsConstructor
public class UserRequestDTO {
    private String name;

    // DTO를 Entity클래스로 변경하는 기능
    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .build();
    }

}
