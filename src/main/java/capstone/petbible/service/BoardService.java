package capstone.petbible.service;

import capstone.petbible.domain.Board;
import capstone.petbible.domain.Comment;
import capstone.petbible.dto.BoardDTO;
import capstone.petbible.dto.CommentDTO;

import java.util.List;

public interface BoardService {

    Board createBoard(BoardDTO boardDTO);
    Board getBoardByBoardNo(Long boardNo);
    Board updateBoard(Long boardNo, BoardDTO boardDTO, Long userNo);

    void deleteBoard(Long boardNo, Long userNo);

    Comment addComment(Long boardNo, CommentDTO commentDTO);
    void deleteComment(Long commentNo, Long userNo);

    void addBoardLike(Long boardNo, Long userNo);
    void removeBoardLike(Long boardNo, Long userNo);

    List<Board> getAllBoards();
    List<Board> getUserBoards(Long userNo);
    List<Board> getCategoryBoards(Long categoryNo);
    // 기타 게시글 관련 메소드 선언
}
