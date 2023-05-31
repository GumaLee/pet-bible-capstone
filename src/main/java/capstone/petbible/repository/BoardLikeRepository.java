package capstone.petbible.repository;

import capstone.petbible.domain.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {
    BoardLike getBoardLikeByBoardNo(Long boardNo);
}
