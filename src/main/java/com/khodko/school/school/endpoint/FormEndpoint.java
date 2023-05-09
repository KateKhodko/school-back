package com.khodko.school.school.endpoint;

import com.khodko.school.school.model.Form;
import com.khodko.school.school.repository.FormRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/form")
@Tag(name = "Form", description = "Эндпоинт для входа и прочего (пинг сервера)")
public class FormEndpoint {

    private final FormRepository formRepository;

    @Transactional
    @SecurityRequirement(name = "Get current teacher")
    @GetMapping("/all")
    public ResponseEntity<List<Form>> getAll() {
        return ResponseEntity.ok(formRepository.findAll());
    }
}
