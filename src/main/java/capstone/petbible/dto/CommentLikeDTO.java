package capstone.petbible.dto;

public class CommentLikeDTO {

    private Long commentLikeNo;
    private CommentDTO commentDTO;
    private UserDTO userDTO;

    public Long getCommentLikeNo() {
        return commentLikeNo;
    }

    public void setCommentLikeNo(Long commentLikeNo) {
        this.commentLikeNo = commentLikeNo;
    }

    public CommentDTO getCommentDTO() {
        return commentDTO;
    }

    public void setCommentDTO(CommentDTO commentDTO) {
        this.commentDTO = commentDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
