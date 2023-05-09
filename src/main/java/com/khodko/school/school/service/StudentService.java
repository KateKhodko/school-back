package com.khodko.school.school.service;

import com.khodko.school.school.model.Student;
import com.khodko.school.school.model.User;
import com.khodko.school.school.model.request.UpdateStudentAboutRequest;
import com.khodko.school.school.model.request.UpdateStudentInfoRequest;
import com.khodko.school.school.repository.FormRepository;
import com.khodko.school.school.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserService userService;
    private final FormRepository formRepository;

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student updateStudentInfo(UpdateStudentInfoRequest updateStudentInfoRequest) {
        Student student = studentRepository.findById(updateStudentInfoRequest.getId()).get();
        student.setForm(formRepository.findByName(updateStudentInfoRequest.getForm()));

        User user = userService.findById(student.getUser().getId()).get();
        user.setName(updateStudentInfoRequest.getName());
        user.setAddress(updateStudentInfoRequest.getAddress());
        user.setPhone(updateStudentInfoRequest.getPhone());
        user.setEmail(updateStudentInfoRequest.getEmail());
        userService.update(user);

        return studentRepository.save(student);
    }

    public Student updateStudentAbout(UpdateStudentAboutRequest updateStudentAboutRequest) {
        Student student = studentRepository.findById(updateStudentAboutRequest.getId()).get();

        User user = userService.findById(student.getUser().getId()).get();
        user.setAbout(updateStudentAboutRequest.getAbout());
        userService.update(user);

        return studentRepository.save(student);
    }
}
