package com.example.practice.Service;


import com.example.practice.Data.DTO.ProductRequestDTO;
import com.example.practice.Data.DTO.ProductResponseDTO;
import com.example.practice.Data.Entity.ProductEntity;
import com.example.practice.Data.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public Long ProductSave(ProductRequestDTO productRequestDTO){
        return productRepository.save(productRequestDTO.toEntity()).getPid();
    }

    public List<ProductResponseDTO> ProductSelect(){
        List<ProductEntity> productEntities = productRepository.findAll();
        int count = productEntities.size(); // 객체 개수 구하기
        List<ProductResponseDTO> productResponseDTO = productEntities.stream()
                .map(entity -> {
                    ProductResponseDTO dto = new ProductResponseDTO();
                    dto.setPid(entity.getPid());
                    dto.setPname(entity.getPname());
                    dto.setPprice(entity.getPprice());
                    return dto;
                })
                .collect(Collectors.toList()); // DTO 객체 리스트로 변환

        return productResponseDTO;
    }



    public ProductResponseDTO ProductSelectById(Long id){
        Optional<ProductEntity> product = productRepository.findById(id);
        return product.map(productEntity -> new ProductResponseDTO(productEntity.getPid(),
                productEntity.getPname(), productEntity.getPprice())).orElseGet(ProductResponseDTO::new);

    }

}
