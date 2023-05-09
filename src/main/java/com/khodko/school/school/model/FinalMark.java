package com.khodko.school.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "final_mark")
@EqualsAndHashCode(callSuper = true)
public class FinalMark extends BaseEntity {

    private int mark;

    private int quarter;

    private int formNumber;

    @OneToOne
    private Student student;

    @ManyToOne
    private Subject subject;
}
