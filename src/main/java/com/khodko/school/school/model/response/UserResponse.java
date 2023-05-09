package com.khodko.school.school.model.response;

import com.khodko.school.school.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String about;
    private String phone;
    private String address;
    private Role role;
}
