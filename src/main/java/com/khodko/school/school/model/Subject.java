package com.khodko.school.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject")
@EqualsAndHashCode(callSuper = true)
public class Subject extends BaseEntity {

    @Column
    private String name;
}
