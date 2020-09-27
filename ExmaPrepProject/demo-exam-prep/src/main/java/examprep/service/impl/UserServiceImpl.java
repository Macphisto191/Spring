package examprep.service.impl;

import examprep.model.entity.User;
import examprep.model.service.UserServiceModel;
import examprep.repository.UserRepository;
import examprep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {

        User user = this.modelMapper
                .map(userServiceModel, User.class);
        this.userRepository.saveAndFlush(user);
        UserServiceModel userServiceModel1 = this.modelMapper
                .map(user, UserServiceModel.class);
        return userServiceModel;
    }

    @Override
    public UserServiceModel findByName(String username) {
//        return this.modelMapper
//        .map(this.userRepository.findByUsername(username), UserServiceModel.class );
        return this.userRepository.findByUsername(username)
                .map(user -> {
                   return this.modelMapper.map(user, UserServiceModel.class);
                }).orElse(null);
    }
}
