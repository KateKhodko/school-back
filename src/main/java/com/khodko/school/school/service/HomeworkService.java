package com.khodko.school.school.service;

import com.khodko.school.school.model.Homework;
import com.khodko.school.school.repository.HomeworkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HomeworkService {

    private final HomeworkRepository homeworkRepository;

    public Optional<Homework> findById(Long id) {
        return homeworkRepository.findById(id);
    }

    public List<Homework> findAll() {
        return homeworkRepository.findAll();
    }
}
