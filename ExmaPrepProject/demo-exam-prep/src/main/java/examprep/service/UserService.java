package examprep.service;

import examprep.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel register (UserServiceModel userServiceModel);



    UserServiceModel findByName(String username);
}
