package com.khodko.school.school.service;

import com.khodko.school.school.model.Form;
import com.khodko.school.school.repository.FormRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FormService {

    private final FormRepository formRepository;

    public Form findByName(String name) {
        return formRepository.findByName(name);
    }

    public List<Form> findAll() {
        return formRepository.findAll();
    }

    public Optional<Form> findById(Long id) {
        return formRepository.findById(id);
    }
}
