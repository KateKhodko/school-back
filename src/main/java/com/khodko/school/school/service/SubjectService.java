package com.khodko.school.school.service;

import com.khodko.school.school.model.Subject;
import com.khodko.school.school.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Subject findByName(String name) {
        return subjectRepository.findByName(name);
    }
}
