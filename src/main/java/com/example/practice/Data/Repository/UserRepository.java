package com.example.practice.Data.Repository;

import com.example.practice.Data.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    // (10) JpaRepository를 상속받는 UserRepository 인터페이스의 동작 원리를 설명

    Optional<UserEntity> findById(Long id);

}
