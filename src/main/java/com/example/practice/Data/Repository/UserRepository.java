package com.example.practice.Data.Repository;

import com.example.practice.Data.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    //JpaRepository 인터페이스를 상속받는 인터페이스를 정의하면, Spring Framework에서 이를 구현한 클래스를
    // 자동으로 생성하여 빈(Bean)으로 등록 이렇게 생성된 구현 클래스는 데이터베이스와의 상호작용을 위한 다양한 메서드를 제공

    Optional<UserEntity> findById(Long id);


}
