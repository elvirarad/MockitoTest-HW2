package org.lesson2;

import java.util.List;

public interface UserDao {

    User getUserByName(String name);

    List <User> findAllUsers();
}
