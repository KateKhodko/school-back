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
@Table(name = "form")
@EqualsAndHashCode(callSuper = true)
public class Form extends BaseEntity{

    @Column
    private String name;
}
