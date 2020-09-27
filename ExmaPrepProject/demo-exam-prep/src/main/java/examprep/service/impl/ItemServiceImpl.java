package examprep.service.impl;

import examprep.model.entity.Category;
import examprep.model.entity.Item;
import examprep.model.service.CategoryServiceModel;
import examprep.model.service.ItemServiceModel;
import examprep.model.view.ItemViewModel;
import examprep.repository.ItemRepository;
import examprep.service.CategoryService;
import examprep.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;


    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;

        this.categoryService = categoryService;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        Category category = this.categoryService
                .findByCategoryName(itemServiceModel.getCategory().getCategoryName());

        Item item = this.modelMapper.map(itemServiceModel, Item.class);

        item.setCategory(category);

        this.itemRepository.saveAndFlush(item);

    }

    @Override
    public List<ItemViewModel> findAllItems() {

        return this.itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper
                            .map(item, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(),
                            item.getCategory().getCategoryName().name()));

                    return itemViewModel;
                }).collect(Collectors.toList());
    }
}
