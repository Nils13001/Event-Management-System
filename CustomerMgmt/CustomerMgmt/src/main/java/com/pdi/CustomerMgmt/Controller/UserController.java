package com.pdi.CustomerMgmt.Controller;

import com.pdi.CustomerMgmt.Model.ApiResponse;
import com.pdi.CustomerMgmt.Model.UserModel;
import com.pdi.CustomerMgmt.Model.UserResponse;
import com.pdi.CustomerMgmt.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers(){
        List<UserResponse> users = userService.getAllUsers();
        return new ResponseEntity<>(new ApiResponse<>(true, "Users fetched successfully", users), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable int customerId){
        UserResponse user = userService.getUserById(customerId);
        return new ResponseEntity<>(new ApiResponse<>(true, "User fetched successfully", user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserModel userModel){
        UserResponse userResponse = userService.createUser(userModel);
        return new ResponseEntity<>(new ApiResponse<>(true, "User created successfully", userResponse), HttpStatus.CREATED);
    }

}
