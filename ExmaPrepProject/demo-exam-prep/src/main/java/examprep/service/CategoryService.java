package examprep.service;

import examprep.model.entity.Category;
import examprep.model.entity.CategoryName;
import examprep.model.service.CategoryServiceModel;

public interface CategoryService {

    void initCategories();

    Category findByCategoryName(CategoryName categoryName);
}
