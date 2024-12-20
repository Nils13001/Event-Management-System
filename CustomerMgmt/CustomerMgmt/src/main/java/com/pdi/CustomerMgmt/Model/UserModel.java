package com.pdi.CustomerMgmt.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {

    private String userName;
    private String address;
    private String phoneNum;
}
