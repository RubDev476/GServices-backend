package com.rubev.GServices.dto;

import com.rubev.GServices.model.UserRole;
import com.rubev.GServices.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private Set<UserRole> roles;
    private UserType type;
    private String urlImg;
}
