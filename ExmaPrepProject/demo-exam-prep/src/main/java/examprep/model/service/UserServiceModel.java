package examprep.model.service;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

public class UserServiceModel extends BaseServiceModel {

    private String username;
    private String password;
    private String email;
    private BigDecimal budget;

    public UserServiceModel() {
    }

    @Length(min = 3)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 3)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DecimalMin(value = "0")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
