package com.khodko.school.school.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity {

    @OneToOne
    private User user;

    @Column
    private int experience;

    @Column
    private String education;

    @ManyToMany
    private List<Subject> subjects;

    @ManyToMany
    private List<Form> forms;
}
