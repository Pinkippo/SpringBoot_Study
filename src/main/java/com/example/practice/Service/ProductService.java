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

        // 0505 로직 수정 : 연관관계 매핑으로 로직 변경
        // + 제네릭 타입 및 옵셔널에 대해서 확실하게 알고 넘어갈 것
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

    // 0505 로직 수정 : 연관관계 매핑으로 로직 변경
    // + 더 나아가기 : 해당 로직을 람다가 아닌 다른 방법으로 진행했다면 어떻게 접근해야할지 생각해볼것
    public List<ProductResponseDTO> ProductSelect(){
        List<ProductEntity> productEntities = productRepository.findAll();
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
                .collect(Collectors.toList());

        return productResponseDTO;
    }



    // 0505 로직 수정 : 연관관계 매핑으로 로직 변경
    // + 더 나아가기 : 해당 로직에서 예외처리가 어떻게 되어있는지 파악할 것
    public ProductResponseDTO ProductSelectById(Long id){
        Optional<ProductEntity> product = productRepository.findById(id);
        return product.map(productEntity -> new ProductResponseDTO(productEntity.getPid()
                ,productEntity.getUser().getId(),productEntity.getUser().getName(), productEntity.getPname(),
                        productEntity.getPprice())).orElseGet(ProductResponseDTO::new);
    }

}
