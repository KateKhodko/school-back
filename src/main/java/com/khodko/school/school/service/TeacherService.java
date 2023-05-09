package com.khodko.school.school.service;

import com.khodko.school.school.model.*;
import com.khodko.school.school.model.request.*;
import com.khodko.school.school.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserService userService;
    private final FormService formService;
    private final SubjectService subjectService;

    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher updateTeacherInfo(UpdateTeacherInfoRequest updateTeacherInfoRequest) {
        Teacher teacher = teacherRepository.findById(updateTeacherInfoRequest.getId()).get();
        teacher.setEducation(updateTeacherInfoRequest.getEducation());
        teacher.setExperience(updateTeacherInfoRequest.getExperience());

        User user = userService.findById(teacher.getUser().getId()).get();
        user.setName(updateTeacherInfoRequest.getName());
        user.setAddress(updateTeacherInfoRequest.getAddress());
        user.setPhone(updateTeacherInfoRequest.getPhone());
        user.setEmail(updateTeacherInfoRequest.getEmail());
        userService.update(user);

        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacherAbout(UpdateTeacherAboutRequest updateTeacherAboutRequest) {
        Teacher teacher = teacherRepository.findById(updateTeacherAboutRequest.getId()).get();

        User user = userService.findById(teacher.getUser().getId()).get();
        user.setAbout(updateTeacherAboutRequest.getAbout());
        userService.update(user);

        return teacherRepository.save(teacher);
    }

    public Teacher deleteForm(DeleteTeacherFormRequest deleteTeacherFormRequest) {
        Teacher teacher = teacherRepository.findById(deleteTeacherFormRequest.getId()).get();
        teacher.getForms().remove(formService.findByName(deleteTeacherFormRequest.getForm()));

        return teacherRepository.save(teacher);
    }

    public Teacher deleteSubject(DeleteTeacherSubjectRequest deleteTeacherSubjectRequest) {
        Teacher teacher = teacherRepository.findById(deleteTeacherSubjectRequest.getId()).get();
        teacher.getSubjects().remove(subjectService.findByName(deleteTeacherSubjectRequest.getSubject()));

        return teacherRepository.save(teacher);
    }

    public Teacher addSubject(AddTeacherSubjectRequest addTeacherSubjectRequest) {
        Teacher teacher = teacherRepository.findById(addTeacherSubjectRequest.getTeacherId()).get();
        Subject subject = subjectService.findById(addTeacherSubjectRequest.getId()).get();
        if (!teacher.getSubjects().contains(subject)) {
            teacher.getSubjects().add(subject);
        }

        return teacherRepository.save(teacher);
    }

    public Teacher addForm(AddTeacherFormRequest addTeacherFormRequest) {
        Teacher teacher = teacherRepository.findById(addTeacherFormRequest.getTeacherId()).get();
        Form form = formService.findById(addTeacherFormRequest.getId()).get();
        if (!teacher.getForms().contains(form)) {
            teacher.getForms().add(form);
        }
        return teacherRepository.save(teacher);
    }
}
