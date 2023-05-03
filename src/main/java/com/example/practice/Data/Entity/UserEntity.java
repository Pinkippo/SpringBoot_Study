package com.example.practice.Data.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "user")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성할때 널로두면 자동으로 들어감
    // PK 설정 + 자동 생성
    @Column(name="userId")
    private Long id;

    @Column(name = "userName",length = 10, nullable = false)
    private String name;

    @Builder
    public UserEntity(String name){
        this.name = name;
    }

}
