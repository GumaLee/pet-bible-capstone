package capstone.petbible.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateUserRequest {

    /* 회원 생성 시 클라이언트로부터 전달받는 값
    * 이메일
    * 비밀번호
    * 닉네임
    * */
    private String userEmail;
    private String userPw;
    private String nickname;

}
