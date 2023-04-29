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
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pId")
    private Long pid;

    @Column(name = "productName",length = 20, nullable = false)
    private String pname;

    @Column(name = "productPrice", nullable = false)
    private int pprice;

    @Builder
    public ProductEntity(String pname, int pprice){
        this.pname = pname;
        this.pprice = pprice;
    }

}
