package com.khodko.school.school.service;

import com.khodko.school.school.mapper.UserMapper;
import com.khodko.school.school.model.User;
import com.khodko.school.school.model.enums.Role;
import com.khodko.school.school.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectDeletedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() != Role.ADMIN)
                .toList();
    }

    public Set<User> findByIds(Collection<Long> ids) {
        return userRepository.findByIdIn(ids);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User create(User createdUser) {

        checkExisting(userRepository.findByEmail(createdUser.getEmail()), "User with this login already exists!");

        return userRepository.save(createdUser);
    }

    public User update(User updatedUser) {
//        checkExisting(userRepository.findByEmail(updatedUser.getEmail()),
//                "User with this login already exists!");

        var user = userRepository.findById(updatedUser.getId()).orElseThrow(EntityNotFoundException::new);

        userMapper.update(user, updatedUser);

        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.findById(id)
                .ifPresentOrElse(user -> {
                    if (Objects.nonNull(user.getDeleted()))
                        throw new ObjectDeletedException(
                                "User was already deleted!",
                                user.getId(),
                                user.toString());

                    user.setDeleted(LocalDate.now());
                }, () -> {
                    throw new EntityNotFoundException();
                });
    }

    private void checkExisting(User user, String message) {
        Optional.ofNullable(user).ifPresent(foundedUser -> { throw new EntityExistsException(message); });
    }
}
