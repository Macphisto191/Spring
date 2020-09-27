package examprep.repository;

import examprep.model.entity.Item;
import examprep.model.view.ItemViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository <Item, String> {


}
