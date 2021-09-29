package com.fgorostiaga.springcourse.dao;

import com.fgorostiaga.springcourse.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    List<User> getUsers();

    int delete(int id);

    User update(User user);

    User create(User user);
}
