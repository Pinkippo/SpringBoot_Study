package com.example.practice.Data.DTO;

import com.example.practice.Data.Entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    // 0505: 연관관계 매핑으로 로직 변경
    public Long userid;
    public String pname;
    public int pprice;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .pname(pname)
                .pprice(pprice)
                .build();
    }

}
