package com.khodko.school.school.repository;

import com.khodko.school.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Set<User> findByIdIn(Collection<Long> ids);
}
