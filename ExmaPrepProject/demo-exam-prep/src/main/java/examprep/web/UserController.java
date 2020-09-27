package examprep.web;

import examprep.model.binding.UserLoginBindingModel;
import examprep.model.binding.UserRegisterBindingModel;
import examprep.model.service.UserServiceModel;
import examprep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(@Valid @ModelAttribute ("userRegisterBindingModel")
                                       UserRegisterBindingModel userRegisterBindingModel) {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute ("userRegisterBindingModel")
                                              UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes
                                 ) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())){
            // todo redirect  attributes
            return "redirect:register";
        }

        this.userService.register(this.modelMapper
        .map(userRegisterBindingModel, UserServiceModel.class));

    return "redirect:login";
    }

    @PostMapping("/login")
    public String loginConfirm (@Valid @ModelAttribute("userLoginBindingModel")
                                            UserLoginBindingModel userLoginBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                HttpSession httpSession){

        if (bindingResult.hasErrors()){
            return "redirect:login";
        }

        UserServiceModel userServiceModel = this.userService.findByName(userLoginBindingModel.getUsername());
        if (userServiceModel == null || !userServiceModel.getPassword().equals(userLoginBindingModel.getPassword())){
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }

        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";


    }
    @GetMapping("/logout")
    public String logout (){
        return "redirect:login";
    }
}
