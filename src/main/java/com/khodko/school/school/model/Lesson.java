package com.khodko.school.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lesson")
@EqualsAndHashCode(callSuper = true)
public class Lesson extends BaseEntity {

    @ManyToOne
    private Subject subject;
    @Column
    private String startTime;
    @Column
    private int weekDay;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Form form;
    private String classroom;
}
