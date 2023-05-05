package com.example.practice.Service;


import com.example.practice.Data.DTO.ProductRequestDTO;
import com.example.practice.Data.DTO.ProductResponseDTO;
import com.example.practice.Data.Entity.ProductEntity;
import com.example.practice.Data.Entity.UserEntity;
import com.example.practice.Data.Repository.ProductRepository;
import com.example.practice.Data.Repository.UserRepository;
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

    private final UserRepository userRepository;

    public Long ProductSave(ProductRequestDTO productRequestDTO){

        // 0505: 연관관계 매핑으로 로직 변경
        Optional<UserEntity> user = userRepository.findById(productRequestDTO.getUserid());
        if(user.isPresent()) {
            ProductEntity product = new ProductEntity(
                    user.get(),
                    productRequestDTO.getPname(),
                    productRequestDTO.getPprice()
            );
            return productRepository.save(product).getPid();
        }else{
            return null;
        }
    }

    public List<ProductResponseDTO> ProductSelect(){
        List<ProductEntity> productEntities = productRepository.findAll();
        // 0505: 연관관계 매핑으로 로직 변경
        List<ProductResponseDTO> productResponseDTO = productEntities.stream()
                .map(entity -> {
                    ProductResponseDTO dto = new ProductResponseDTO();
                    dto.setPid(entity.getPid());
                    dto.setUserid(entity.getUser().getId());
                    dto.setUsername(entity.getUser().getName());
                    dto.setPname(entity.getPname());
                    dto.setPprice(entity.getPprice());
                    return dto;
                })
                .collect(Collectors.toList()); // DTO 객체 리스트로 변환

        return productResponseDTO;
    }



    public ProductResponseDTO ProductSelectById(Long id){
        Optional<ProductEntity> product = productRepository.findById(id);
        // 0505: 연관관계 매핑으로 로직 변경
        return product.map(productEntity -> new ProductResponseDTO(productEntity.getPid()
                ,productEntity.getUser().getId(),productEntity.getUser().getName(), productEntity.getPname(),
                        productEntity.getPprice())).orElseGet(ProductResponseDTO::new);
    }

}
