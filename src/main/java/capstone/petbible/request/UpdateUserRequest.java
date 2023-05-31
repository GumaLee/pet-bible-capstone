package capstone.petbible.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {

    /*
    * 사용자에게 Password 받아서 확인
    * 변경할 이메일도 받음
    */
    private String userPw;
    private String newEmail;
}
