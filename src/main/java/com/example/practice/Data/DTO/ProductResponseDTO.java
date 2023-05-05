package com.example.practice.Data.DTO;

import com.example.practice.Data.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private Long pid;
    // 0505: 연관관계 매핑으로 로직 변경
    private Long userid;
    private String username;
    private String pname;
    private int pprice;


}
