package com.example.practice.Controller;

import com.example.practice.Service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*
    1. 상품 등록 메서드 작성
    조건 : post 방식으로 인자를 받아 db에 저장하고 리턴값으로 해당 상품의 id값을 리턴
    + 숙제 : DTO를 이용해서 만들것
    */

    /*
    2. 상품 조회 메서드 작성
    조건 : db내에 존재하는 모든 상품 리스트를 리턴할 것
    + 숙제 : 해당 엔티티를 엔티티의 리스트가 아니라 responseDTO를 작성해 List<responesDTO> 로 리턴할 것
     */


    /*
    3. 상품의 이름으로 조회 메서드 작성
    조건 : db내에 존재할경우 객체 전송 아닐경우 상품이없다고 전송
    + 숙제 : 마찬가지로 responseDTO로 캐스팅해서 리턴할 것
     */

}
