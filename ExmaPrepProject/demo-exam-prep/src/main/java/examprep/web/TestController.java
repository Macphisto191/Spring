package examprep.web;

import examprep.model.binding.UserRegisterBindingModel;
import examprep.model.service.UserServiceModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/welcome")
    public String showHome (Model model){
        return "welcome";
    }
    @GetMapping("/registration_form")
    public String registrationForm (Model model, UserRegisterBindingModel user){
//        UserServiceModel user = new UserServiceModel();
        model.addAttribute("user", user);
        return "registration_form";
    }
}
