package capstone.petbible.dto;

public class BoardLikeDTO {

    private Long boardLikeNo;
    private BoardDTO boardDTO;
    private UserDTO userDTO;

    public Long getBoardLikeNo() {
        return boardLikeNo;
    }

    public void setBoardLikeNo(Long boardLikeNo) {
        this.boardLikeNo = boardLikeNo;
    }

    public BoardDTO getBoardDTO() {
        return boardDTO;
    }

    public void setBoardDTO(BoardDTO boardDTO) {
        this.boardDTO = boardDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
