package com.khodko.school.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mark")
@EqualsAndHashCode(callSuper = true)
public class Mark extends BaseEntity {

    @Column
    private LocalDate date;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Lesson lesson;
    @Column
    private int mark;
}
