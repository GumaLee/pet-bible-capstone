package capstone.petbible.mapper;

import capstone.petbible.domain.User;
import capstone.petbible.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserNo(user.getUserNo());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserPw(userDTO.getUserPw());
        user.setNickname(userDTO.getNickname());
        user.setRegDate(userDTO.getRegDate());
        user.setUpdateDate(userDTO.getUpdateDate());
        user.setAuthNum(userDTO.getAuthNum());

        return userDTO;
    }
}
