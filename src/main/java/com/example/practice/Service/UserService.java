package com.example.practice.Service;

import com.example.practice.Data.DTO.UserRequestDTO;
import com.example.practice.Data.DTO.UserResponseDTO;
import com.example.practice.Data.Entity.UserEntity;
import com.example.practice.Data.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service //해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성
@RequiredArgsConstructor // final + not null 붙은 것 대신 생성자 생성
@Transactional
public class UserService {
    private final UserRepository userRepository;
    // 레파지토리 의존성 주입

    @Transactional
    public void SaveUser(UserRequestDTO userRequestDTO){ //유저 저장
        userRepository.save(userRequestDTO.toEntity());
    }

    @Transactional
    public UserResponseDTO SelectUserById(Long id) { //Id로 유저 정보 가져오기
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new UserResponseDTO(user.get().getId(), user.get().getName());
        } else {
            return null;
        }
    }

}
