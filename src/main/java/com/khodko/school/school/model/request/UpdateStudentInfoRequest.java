package com.khodko.school.school.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentInfoRequest {

    private String name;
    private String email;
    private String address;
    private String form;
    private String phone;
    private Long id;
}
