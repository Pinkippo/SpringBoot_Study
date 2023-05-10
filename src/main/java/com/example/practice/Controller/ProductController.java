package com.example.practice.Controller;

import com.example.practice.Data.DTO.ProductRequestDTO;
import com.example.practice.Data.DTO.ProductResponseDTO;
import com.example.practice.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*
    상품 등록 메서드 작성
    조건 : post 방식으로 인자를 받아 db에 저장하고 리턴값으로 해당 상품의 id값을 리턴

    + 0505 로직 수정 : 연관관계 매핑으로 저장 로직 변경
    */
    @PostMapping("/save")
    public Long ProductSave(@RequestBody ProductRequestDTO productRequestDTO){
        return productService.ProductSave(productRequestDTO);
    }

    /*
    상품 조회 메서드 작성
    조건 : 데이터베이스에 존재하는 모든 상품 리스트를 리턴할 것

    + 0505 로직 수정 : 해당 상품을 등록한 사용자의 id와 이름을 함께 리턴해줌
    + 더 나아가기 : 순환참조를 어떻게 막았는지 후에 한방 쿼리를 사용할때는 어떻게 해보는 것이 좋을지 생각해볼것

     */
    @GetMapping("/select")
    public Result ProductSelect(){
        List<ProductResponseDTO> collect = productService.ProductSelect();
        return new Result(collect.size(),collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private int count;
        private T data;
    }

    /*
    상품의 이름으로 조회 메서드 작성
    조건 : db내에 존재할경우 객체 전송 아닐경우 상품이없다고 전송

    + 더 나아가기 : 프론트엔드와 협력할때 어떻게 하는 것이 예외 처리에 좋을까 생각해볼것
     */
    @GetMapping("/select/{id}")
    public ProductResponseDTO ProductSelectById(@PathVariable("id") Long id){
        return productService.ProductSelectById(id);
    }

}
