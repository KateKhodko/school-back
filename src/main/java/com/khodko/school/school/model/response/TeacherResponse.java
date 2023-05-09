package com.khodko.school.school.model.response;

import com.khodko.school.school.model.Form;
import com.khodko.school.school.model.Subject;
import com.khodko.school.school.model.Teacher;
import com.khodko.school.school.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class TeacherResponse {

    private String email;
    private String name;
    private String address;
    private String about;
    private String phone;
    private String education;
    private int experience;
    private Role role;
    private List<String> subjects;
    private List<String> forms;
    private Long id;

    public TeacherResponse from(Teacher teacher) {
        this.email = teacher.getUser().getEmail();
        this.name = teacher.getUser().getName();
        this.address = teacher.getUser().getAddress();
        this.about = teacher.getUser().getAbout();
        this.phone = teacher.getUser().getPhone();
        this.role = teacher.getUser().getRole();
        this.subjects = teacher.getSubjects().stream().map(Subject::getName).collect(Collectors.toList());
        this.forms = teacher.getForms().stream().map(Form::getName).collect(Collectors.toList());
        this.experience = teacher.getExperience();
        this.education = teacher.getEducation();
        this.role = teacher.getUser().getRole();
        this.id = teacher.getId();
        return this;
    }
}
