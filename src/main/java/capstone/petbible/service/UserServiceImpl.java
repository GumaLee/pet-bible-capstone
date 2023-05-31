package capstone.petbible.service;

import capstone.petbible.domain.User;
import capstone.petbible.dto.UserDTO;
import capstone.petbible.mapper.UserMapper;
import capstone.petbible.repository.UserRepository;
import capstone.petbible.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(CreateUserRequest request) {
        // 사용자 생성 로직 구현
        if(userRepository.findByNickname(request.getNickname()) != null) {
            throw new IllegalArgumentException("Nickname already exists: " + request.getNickname());
        }

        LocalDateTime now = LocalDateTime.now();

        User user = new User();

        user.setUserEmail(request.getUserEmail());
        user.setUserPw(request.getUserPw());
        user.setNickname(request.getNickname());
        user.setRegDate(now);
        user.setUpdateDate(now);
        // user.setAuthNum(userDTO.getAuthNum());

        User savedUser = userRepository.save(user);

        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO getUserByUserNo(Long userNo) {
        // 사용자 조회 로직 구현
        User user = userRepository.getUserByUserNo(userNo);
        if(user == null) {
            throw new EntityNotFoundException("User not found with userNo: " + userNo);
        }
        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUser(Long userNo, String password, String newEmail) {
        // 사용자 정보 조회
        User user = userRepository.findByUserNo(userNo);
        if(user == null) {
            throw new EntityNotFoundException("User not found with userNo: " + userNo);
        }

        // 비밀번호 일치 여부 확인
        if(!passwordEncoder.matches(password, user.getUserPw())) {
            throw new IllegalArgumentException("Incorrect password");
        }

        user.setUserEmail(newEmail);
        user.setUpdateDate(LocalDateTime.now());

        User updatedUser = userRepository.save(user);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userNo) {
        // 사용자 삭제 로직 구현
        User user = userRepository.findByUserNo(userNo);
        if(user == null) {
            throw new EntityNotFoundException("User not found with userNo: " + userNo);
        }

        userRepository.delete(user);
    }

    // 기타 사용자 관련 메소드 구현
}
