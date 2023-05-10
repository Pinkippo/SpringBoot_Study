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

    /*
    1. 프로덕트 엔티티에 유저 엔티티 매핑
     */
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 -> 즉 객체가 필요한 시점에 쿼리가 나감 -> 후에 실력이 늘면 fetch join 한방 쿼리 공부
    @JoinColumn(name = "userId")
    private UserEntity user; // 상품 엔티티에 유저 엔티티 매핑하여 연관관계 성립

    @Column(name = "productName",length = 20, nullable = false)
    private String pname;

    @Column(name = "productPrice", nullable = false)
    private int pprice;


    /*
    3. 연관관계 매핑 덕분에 바뀐 빌더 타입 -> 유저 엔티티를 함께 작성해줘야 한다
     */
    @Builder
    public ProductEntity(UserEntity user,String pname, int pprice){
        this.user = user;
        this.pname = pname;
        this.pprice = pprice;
    }

}
