package com.example.practice.Service;

import com.example.practice.Data.DTO.UserRequestDTO;
import com.example.practice.Data.DTO.UserResponseDTO;
import com.example.practice.Data.Entity.UserEntity;
import com.example.practice.Data.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void SaveUser(UserRequestDTO userRequestDTO){ // (12) 해당 로직을 간단하게 설명
        userRepository.save(userRequestDTO.toEntity());
    }

    @Transactional
    public UserResponseDTO SelectUserById(Long id) {  // id로 select
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new UserResponseDTO(user.get().getId(), user.get().getName());
        } else {
            return null;
        }
    }

}
