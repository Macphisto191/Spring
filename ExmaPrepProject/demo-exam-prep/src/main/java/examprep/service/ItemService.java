package examprep.service;

import examprep.model.service.ItemServiceModel;
import examprep.model.view.ItemViewModel;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();
}
