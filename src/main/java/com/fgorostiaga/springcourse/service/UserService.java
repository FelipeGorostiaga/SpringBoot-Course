package com.fgorostiaga.springcourse.service;

import com.fgorostiaga.springcourse.model.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    List<User> getUsers();

    int delete(int id);

    User update(User user);

    User create(User user);
}
