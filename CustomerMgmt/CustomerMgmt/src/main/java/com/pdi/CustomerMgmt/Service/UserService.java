package com.pdi.CustomerMgmt.Service;


import com.pdi.CustomerMgmt.Model.UserModel;
import com.pdi.CustomerMgmt.Model.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUserById(int customerId);

    UserResponse createUser(UserModel userModel);
}
