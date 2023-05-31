package capstone.petbible.repository;

import capstone.petbible.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment getCommentByCommentNo(Long CommentNo);
}
