package com.pdi.CustomerMgmt.Service;

import com.pdi.CustomerMgmt.Entity.UserEntity;
import com.pdi.CustomerMgmt.Error.UserNotFoundException;
import com.pdi.CustomerMgmt.Model.UserModel;
import com.pdi.CustomerMgmt.Model.UserResponse;
import com.pdi.CustomerMgmt.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getUserId(), user.getUserName(), user.getAddress(), user.getPhoneNum()))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(int customerId) {
        UserEntity user = userRepository.findByUserId(customerId).orElseThrow(() -> new UserNotFoundException("User with this id doesn't exist"));
        return new UserResponse(user.getUserId(), user.getUserName(), user.getAddress(), user.getPhoneNum());
    }

    @Override
    public UserResponse createUser(UserModel userModel) {
        UserEntity user = new UserEntity();
        user.setUserName(userModel.getUserName());
        user.setAddress(userModel.getAddress());
        user.setPhoneNum(userModel.getPhoneNum());
        user = userRepository.save(user);
        return new UserResponse(user.getUserId(), user.getUserName(), user.getAddress(), user.getPhoneNum());
    }
}
