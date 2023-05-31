package capstone.petbible.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {

    private Long userNo;
    private String userEmail;
    private String userPw;
    private String nickname;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private String authNum;

    private List<BoardDTO> boardDTOS;
    private List<CommentDTO> commentDTOS;
    private List<BoardLikeDTO> boardLikeDTOS;
    private List<CommentLikeDTO> commentLikeDTOS;

    public List<BoardDTO> getBoardDTOS() {
        return boardDTOS;
    }

    public void setBoardDTOS(List<BoardDTO> boardDTOS) {
        this.boardDTOS = boardDTOS;
    }

    public List<CommentDTO> getCommentDTOS() {
        return commentDTOS;
    }

    public void setCommentDTOS(List<CommentDTO> commentDTOS) {
        this.commentDTOS = commentDTOS;
    }

    public List<BoardLikeDTO> getBoardLikeDTOS() {
        return boardLikeDTOS;
    }

    public void setBoardLikeDTOS(List<BoardLikeDTO> boardLikeDTOS) {
        this.boardLikeDTOS = boardLikeDTOS;
    }

    public List<CommentLikeDTO> getCommentLikeDTOS() {
        return commentLikeDTOS;
    }

    public void setCommentLikeDTOS(List<CommentLikeDTO> commentLikeDTOS) {
        this.commentLikeDTOS = commentLikeDTOS;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuthNum() {
        return authNum;
    }

    public void setAuthNum(String authNum) {
        this.authNum = authNum;
    }
}
