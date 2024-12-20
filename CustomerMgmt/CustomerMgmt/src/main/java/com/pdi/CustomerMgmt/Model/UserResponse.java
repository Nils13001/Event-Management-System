package com.pdi.CustomerMgmt.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

    private int userId;
    private String userName;
    private String address;
    private String phoneNum;
}
