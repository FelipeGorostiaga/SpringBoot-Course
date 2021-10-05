package com.fgorostiaga.springcourse.service;

import com.fgorostiaga.springcourse.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(long id);

    List<User> getUsers();

    void delete(long id);

    User update(User user);

    User create(User user);
}
