package com.khodko.school.school.endpoint;

import com.khodko.school.school.configuration.jwt.JwtUser;
import com.khodko.school.school.model.User;
import com.khodko.school.school.model.request.UpdateStudentAboutRequest;
import com.khodko.school.school.model.request.UpdateStudentInfoRequest;
import com.khodko.school.school.model.response.StudentResponse;
import com.khodko.school.school.service.StudentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
@Tag(name = "Student", description = "Эндпоинт для входа и прочего (пинг сервера)")
public class StudentEndpoint {

    private final StudentService studentService;

    @Transactional
    @SecurityRequirement(name = "Get current student")
    @GetMapping("/current")
    public ResponseEntity<StudentResponse> getCurrentStudent(@AuthenticationPrincipal JwtUser jwtUser) {
        User user = jwtUser.getUser();
        return ResponseEntity.ok(new StudentResponse().from(studentService.findById(user.getId()).get()));
    }

    @Transactional
    @SecurityRequirement(name = "Update student info")
    @PostMapping("/updateInfo")
    public ResponseEntity<StudentResponse> updateStudentInfo(@RequestBody UpdateStudentInfoRequest updateStudentInfoRequest) {
        return ResponseEntity.ok(new StudentResponse().from(studentService.updateStudentInfo(updateStudentInfoRequest)));
    }

    @Transactional
    @SecurityRequirement(name = "Update student info")
    @PostMapping("/updateAbout")
    public ResponseEntity<StudentResponse> updateStudentAbout(@RequestBody UpdateStudentAboutRequest updateStudentAboutRequest) {
        return ResponseEntity.ok(new StudentResponse().from(studentService.updateStudentAbout(updateStudentAboutRequest)));
    }
}
