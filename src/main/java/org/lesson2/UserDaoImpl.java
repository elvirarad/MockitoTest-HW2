package org.lesson2;

import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final List<User> users;

    public UserDaoImpl(){
        this.users = Arrays.asList(
                new User("Sem", 35, "sem123@mail.com"),
                new User("Tom", 23, "tom123@mail.de")
        );
    }

    @Override
    public User getUserByName(String name){
        for (User user : users){
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;  // м-д никогда не д.возвращать null!!!  Здесь только для примера
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

}
