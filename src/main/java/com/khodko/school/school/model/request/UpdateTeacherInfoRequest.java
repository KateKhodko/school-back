package com.khodko.school.school.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTeacherInfoRequest {

    private String name;
    private String email;
    private String address;
    private String phone;
    private int experience;
    private String education;
    private Long id;
}
