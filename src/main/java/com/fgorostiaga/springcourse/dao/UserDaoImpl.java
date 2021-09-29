package com.fgorostiaga.springcourse.dao;

import com.fgorostiaga.springcourse.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "Felipe", LocalDate.now()));
        users.add(new User(2, "Juan", LocalDate.now()));
        users.add(new User(3, "Pedro", LocalDate.now()));
        users.add(new User(4, "Jose", LocalDate.now()));
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public int delete(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return 1;
            }
        }
        return 0;
    }

    @Override
    public User create(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
