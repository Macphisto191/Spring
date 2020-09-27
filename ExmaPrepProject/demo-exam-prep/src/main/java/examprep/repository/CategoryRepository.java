package examprep.repository;

import examprep.model.entity.Category;
import examprep.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <Category, String> {
    Optional<Category> findByCategoryName (CategoryName categoryName);
}
