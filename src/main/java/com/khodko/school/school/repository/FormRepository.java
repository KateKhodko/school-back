package com.khodko.school.school.repository;

import com.khodko.school.school.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    Form findByName(String name);
}
