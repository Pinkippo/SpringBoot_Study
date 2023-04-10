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
@Table(name = "user") // (8) 현재 클래스 상단에 달려있는 어노테이션 5개의 역할 주석으로 작성
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // (9) 위의 두개의 어노테이션의 역할 주석으로 작성
    @Column(name="userId")
    private Long id;

    @Column(name = "userName",length = 30, nullable = false)
    private String name;

    @Builder
    public UserEntity(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
