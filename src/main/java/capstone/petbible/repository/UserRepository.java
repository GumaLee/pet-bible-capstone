package capstone.petbible.repository;

import capstone.petbible.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNo(Long userNo);
    User findByNickname(String nickname);
    User getUserByUserNo(Long userNo);
}
