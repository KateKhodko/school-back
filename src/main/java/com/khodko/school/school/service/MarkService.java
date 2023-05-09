package com.khodko.school.school.service;

import com.khodko.school.school.model.Mark;
import com.khodko.school.school.repository.MarkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarkService {

    private final MarkRepository markRepository;

    public Optional<Mark> findById(Long id) {
        return markRepository.findById(id);
    }

    public List<Mark> findAll() {
        return markRepository.findAll();
    }
}
