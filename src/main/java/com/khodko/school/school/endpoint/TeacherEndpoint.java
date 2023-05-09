package com.khodko.school.school.endpoint;

import com.khodko.school.school.configuration.jwt.JwtUser;
import com.khodko.school.school.model.User;
import com.khodko.school.school.model.request.*;
import com.khodko.school.school.model.response.TeacherResponse;
import com.khodko.school.school.service.TeacherService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
@Tag(name = "Teacher", description = "Эндпоинт для входа и прочего (пинг сервера)")
public class TeacherEndpoint {

    private final TeacherService teacherService;

    @Transactional
    @SecurityRequirement(name = "Get current teacher")
    @GetMapping("/current")
    public ResponseEntity<TeacherResponse> getCurrentTeacher(@AuthenticationPrincipal JwtUser jwtUser) {
        User user = jwtUser.getUser();
        return ResponseEntity.ok(new TeacherResponse().from(teacherService.findById(user.getId()).get()));
    }

    @Transactional
    @SecurityRequirement(name = "Update teacher info")
    @PostMapping("/updateInfo")
    public ResponseEntity<TeacherResponse> updateStudentInfo(@RequestBody UpdateTeacherInfoRequest updateTeacherInfoRequest) {
        return ResponseEntity.ok(new TeacherResponse().from(teacherService.updateTeacherInfo(updateTeacherInfoRequest)));
    }

    @Transactional
    @SecurityRequirement(name = "Update teacher info")
    @PostMapping("/updateAbout")
    public ResponseEntity<TeacherResponse> updateStudentAbout(@RequestBody UpdateTeacherAboutRequest updateTeacherAboutRequest) {
        return ResponseEntity.ok(new TeacherResponse().from(teacherService.updateTeacherAbout(updateTeacherAboutRequest)));
    }

    @Transactional
    @SecurityRequirement(name = "Delete subject")
    @PostMapping("/deleteSubject")
    public ResponseEntity<TeacherResponse> deleteSubject(@RequestBody DeleteTeacherSubjectRequest deleteTeacherSubjectRequest) {
        return ResponseEntity.ok(new TeacherResponse().from(teacherService.deleteSubject(deleteTeacherSubjectRequest)));
    }

    @Transactional
    @SecurityRequirement(name = "Delete subject")
    @PostMapping("/deleteForm")
    public ResponseEntity<TeacherResponse> deleteForm(@RequestBody DeleteTeacherFormRequest deleteTeacherFormRequest) {
        return ResponseEntity.ok(new TeacherResponse().from(teacherService.deleteForm(deleteTeacherFormRequest)));
    }

    @Transactional
    @SecurityRequirement(name = "Delete form")
    @PostMapping("/addSubject")
    public ResponseEntity<TeacherResponse> addSubject(@RequestBody AddTeacherSubjectRequest addTeacherSubjectRequest) {
        return ResponseEntity.ok(new TeacherResponse().from(teacherService.addSubject(addTeacherSubjectRequest)));
    }

    @Transactional
    @SecurityRequirement(name = "Delete form")
    @PostMapping("/addForm")
    public ResponseEntity<TeacherResponse> addForm(@RequestBody AddTeacherFormRequest teacherFormRequest) {
        return ResponseEntity.ok(new TeacherResponse().from(teacherService.addForm(teacherFormRequest)));
    }
}
