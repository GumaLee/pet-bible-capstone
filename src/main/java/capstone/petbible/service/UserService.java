package capstone.petbible.service;

import capstone.petbible.domain.User;
import capstone.petbible.dto.UserDTO;
import capstone.petbible.request.CreateUserRequest;
import capstone.petbible.request.UpdateUserRequest;

public interface UserService {

    UserDTO createUser(CreateUserRequest request);

    UserDTO getUserByUserNo(Long userNo);

    UserDTO updateUser(Long userNo, String userPw, String newEmail);

    void deleteUser(Long userNo);
    // 기타 사용자 관련 메소드 선언
}
