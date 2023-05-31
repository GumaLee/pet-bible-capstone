package capstone.petbible.service;

import capstone.petbible.domain.*;
import capstone.petbible.dto.BoardDTO;
import capstone.petbible.dto.CommentDTO;
import capstone.petbible.repository.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final BoardLikeRepository boardLikeRepository;
    private final CategoryRepository categoryRepository;

    public BoardServiceImpl(BoardRepository boardRepository, UserRepository userRepository,
                            CommentRepository commentRepository, BoardLikeRepository boardLikeRepository,
                            CategoryRepository categoryRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.boardLikeRepository = boardLikeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Board createBoard(BoardDTO boardDTO) {

        User user = userRepository.getUserByUserNo(boardDTO.getUserNo());
        if(user == null) {
            throw new EntityNotFoundException("User not found with userNo: " + boardDTO.getUserNo());
        }

        Category category = categoryRepository.getCategoryByCategoryNo(boardDTO.getCategoryDTO().getCategoryNo());
        if(category == null) {
            throw new EntityNotFoundException("Category not found with categoryNo: " + boardDTO.getCategoryDTO().getCategoryNo());
        }

        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setContents(boardDTO.getContents());
        board.setRegDate(boardDTO.getRegDate());
        board.setUpdateDate(boardDTO.getUpdateDate());
        board.setUser(user);
        board.setCategory(category);

        board = boardRepository.save(board);

        return board;
    }

    @Override
    public Board getBoardByBoardNo(Long boardNo) {
        Board board = boardRepository.getBoardByBoardNo(boardNo);
        if(board == null) {
            throw new EntityNotFoundException("Board not found with boardNo: " + boardNo);
        }

        return board;
    }

    @Override
    public Board updateBoard(Long boardNo, BoardDTO boardDTO, Long userNo) {
        Board board = boardRepository.getBoardByBoardNo(boardNo);
        if(board == null) {
            throw new EntityNotFoundException("Board not found with boardNo: " + boardNo);
        }

        if(!board.getUser().getUserNo().equals(userNo)) {
            throw new IllegalArgumentException("User does not have permission to update this board.");
        }

        board.setTitle(boardDTO.getTitle());
        board.setContents(boardDTO.getContents());
        board.setUpdateDate(boardDTO.getUpdateDate());

        board = boardRepository.save(board);

        return board;
    }

    @Override
    public void deleteBoard(Long boardNo, Long userNo) {
        Board board = boardRepository.getBoardByBoardNo(boardNo);
        if(board == null) {
            throw new EntityNotFoundException("Board not found with boardNo: " + boardNo);
        }

        if(!board.getUser().getUserNo().equals(userNo)) {
            throw new IllegalArgumentException("User does not have permission to update this board.");
        }

        boardRepository.delete(board);
    }

    @Override
    public Comment addComment(Long boardNo, CommentDTO commentDTO) {
        Board board = getBoardByBoardNo(boardNo);
        User user = userRepository.getUserByUserNo(commentDTO.getUserDTO().getUserNo());

        if(user == null) {
            throw new EntityNotFoundException("User not found with userNo: " + commentDTO.getUserDTO().getUserNo());
        }

        Comment comment = new Comment();
        comment.setCommentNo(comment.getCommentNo());
        comment.setContents(commentDTO.getContent());
        comment.setRegDate(commentDTO.getRegDate());
        comment.setUpdateDate(commentDTO.getUpdateDate());
        comment.setBoard(board);
        comment.setUser(user);

        comment = commentRepository.save(comment);

        return comment;
    }

    @Override
    public void deleteComment(Long commentNo, Long userNo) {
        Comment comment = commentRepository.getCommentByCommentNo(commentNo);
        if(comment == null) {
            throw new EntityNotFoundException("Comment not found with commentNO: " + commentNo);
        }

        if(!comment.getUser().getUserNo().equals(userNo)) {
            throw new IllegalArgumentException("User does not have permission to delete this comment.");
        }

        commentRepository.delete(comment);
    }

    @Override
    public void addBoardLike(Long boardNo, Long userNo) {
        Board board = getBoardByBoardNo(boardNo);
        User user = userRepository.findByUserNo(userNo);

        if(user == null) {
            throw new EntityNotFoundException("User not found with userNo: " + userNo);
        }

        BoardLike boardLike = new BoardLike();
        boardLike.setBoard(board);
        boardLike.setUser(user);

        boardLikeRepository.save(boardLike);
    }

    @Override
    public void removeBoardLike(Long boardNo, Long userNo) {
        BoardLike boardLike = boardLikeRepository.getBoardLikeByBoardNo(boardNo);
        if(boardLike == null) {
            throw new EntityNotFoundException("BoardLike not found with boardNo: " + boardNo + " and userNo: " + userNo);
        }

        boardLikeRepository.delete(boardLike);
    }

    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> getUserBoards(Long userNo) {
        User user = userRepository.getUserByUserNo(userNo);
        if(user == null) {
            throw new EntityNotFoundException("User not found with userNo: " + userNo);
        }

        return boardRepository.getBoardByUser(user);
    }

    @Override
    public List<Board> getCategoryBoards(Long categoryNo) {
        Category category = categoryRepository.getCategoryByCategoryNo(categoryNo);
        if(category == null) {
            throw new EntityNotFoundException("Category not found with CategoryNo: " + categoryNo);
        }

        return boardRepository.getBoardByCategory(category);
    }
}
