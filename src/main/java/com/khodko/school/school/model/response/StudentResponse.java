package com.khodko.school.school.model.response;

import com.khodko.school.school.model.Student;
import com.khodko.school.school.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

    private String email;
    private String name;
    private String address;
    private String about;
    private String phone;
    private String form;
    private Role role;
    private Long id;

    public StudentResponse from(Student student) {
        this.email = student.getUser().getEmail();
        this.name = student.getUser().getName();
        this.address = student.getUser().getAddress();
        this.about = student.getUser().getAbout();
        this.phone = student.getUser().getPhone();
        this.form = student.getForm().getName();
        this.role = student.getUser().getRole();
        this.id = student.getId();
        return this;
    }
}
