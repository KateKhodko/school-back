package com.khodko.school.school.model;

import com.khodko.school.school.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String about;
    @Column
    private String phone;
    @Column
    private Role role;
    @Column
    private LocalDate deleted;
    @Column
    private String imageUrl;
}
