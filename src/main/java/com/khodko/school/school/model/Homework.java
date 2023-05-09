package com.khodko.school.school.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "homework")
@EqualsAndHashCode(callSuper = true)
public class Homework extends BaseEntity {

    @ManyToOne
    private Form form;

    @ManyToOne
    private Lesson lesson;

    private String description;

    private LocalDate date;

    @ManyToMany
    private List<Material> materials;

}
