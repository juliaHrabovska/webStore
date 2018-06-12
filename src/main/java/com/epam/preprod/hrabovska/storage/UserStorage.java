package com.epam.preprod.hrabovska.storage;

import com.epam.preprod.hrabovska.model.entity.User;

import java.util.*;

/**
 * Storage of users
 */
public class UserStorage {

    private Map<Long, User> users = new HashMap();

    public Map<Long, User> getUsers() {
        return users;
    }

    public UserStorage() {
        User user0 = new User();
        user0.setFirstName("Ivan");
        user0.setSecondName("Ivanov");
        user0.setEmail("ivanov@gmai.com");
        user0.setPassword("password1");
        user0.setDesiredList(true);

        User user1 = new User();
        user1.setFirstName("Petr");
        user1.setSecondName("Petrov");
        user1.setEmail("petrov@gmai.com");
        user1.setPassword("password2");
        user1.setDesiredList(false);

        users.put(user0.getId(), user0);
        users.put(user1.getId(), user1);
    }
}
