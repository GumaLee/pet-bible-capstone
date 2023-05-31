package capstone.petbible.repository;

import capstone.petbible.domain.Board;
import capstone.petbible.domain.Category;
import capstone.petbible.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board getBoardByBoardNo(Long boardNo);

    List<Board> getBoardByUser(User user);

    List<Board> getBoardByCategory(Category category);
}
