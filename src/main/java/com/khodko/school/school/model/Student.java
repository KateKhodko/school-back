package com.khodko.school.school.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity {

    @OneToOne
    private User user;
    @ManyToOne
    private Form form;
}
