package examprep.service.impl;

import examprep.model.entity.Category;
import examprep.model.entity.CategoryName;
import examprep.model.service.CategoryServiceModel;
import examprep.repository.CategoryRepository;
import examprep.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values()
            ).forEach(categoryName -> {
                this.categoryRepository.save(new Category(categoryName,
                        String.format("Description for %s", categoryName.name())));
            });
        }
    }

    @Override
    public Category findByCategoryName(CategoryName categoryName) {

        return this.categoryRepository.findByCategoryName(categoryName).orElse(null);
    }
}
