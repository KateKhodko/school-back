package com.khodko.school.school.service;

import com.khodko.school.school.model.Lesson;
import com.khodko.school.school.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }
}
