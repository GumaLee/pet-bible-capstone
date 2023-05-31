package capstone.petbible.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BoardDTO {

    private Long boardNo;
    private Long userNo;
    private String title;
    private String contents;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    private UserDTO userDTO;
    private CategoryDTO categoryDTO;
    private List<CommentDTO> commentDTOS;
    private List<BoardLikeDTO> boardLikeDTOS;

    public Long getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(Long boardNo) {
        this.boardNo = boardNo;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
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
}
