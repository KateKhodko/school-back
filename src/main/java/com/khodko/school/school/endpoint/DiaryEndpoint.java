package com.khodko.school.school.endpoint;

import com.khodko.school.school.model.request.GetDiaryPageRequest;
import com.khodko.school.school.model.response.DiaryEntry;
import com.khodko.school.school.service.DiaryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
@Tag(name = "Diary", description = "Эндпоинт для входа и прочего (пинг сервера)")
public class DiaryEndpoint {

    private final DiaryService diaryService;

    @Transactional
    @SecurityRequirement(name = "Get diary page")
    @PostMapping("/")
    public ResponseEntity<Map<Integer, List<DiaryEntry>>> getAll(@RequestBody GetDiaryPageRequest getDiaryPageRequest) {
        return ResponseEntity.ok(diaryService.getDiaryPage(getDiaryPageRequest));
    }
}
