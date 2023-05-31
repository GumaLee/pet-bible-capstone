package capstone.petbible.repository;

import capstone.petbible.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getCategoryByCategoryNo(Long categoryNo);
}
