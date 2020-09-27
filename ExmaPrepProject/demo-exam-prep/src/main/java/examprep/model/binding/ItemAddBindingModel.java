package examprep.model.binding;

import examprep.model.entity.Category;
import examprep.model.entity.CategoryName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private BigDecimal price;
    private String gender;
    private CategoryName category;

    public ItemAddBindingModel() {
    }

    @Length(min = 2, message = "Username length must be more than two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 3, message = "Description length must be more than three characters!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DecimalMin(value = "0", message = "Price must be positive!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Length(min = 2, message = "Enter valid gender!")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NotNull(message = "Enter valid category name!")
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }
}
