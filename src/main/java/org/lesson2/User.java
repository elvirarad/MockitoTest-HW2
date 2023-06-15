package org.lesson2;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String email;
    private static String char1 ="@";
    private static String char2 =".";

    public User() {    }

    public User(String name) {
        validationName(name);
        this.name = name;
    }
    public User(String name, String email) {
        validationName(name);
        validationEmail(email);
        this.name = name;
        this.email = email;
    }

    public User(String name, int age, String email) {
        validationParameter(name, age, email);
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validationName(name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void validationEmail(String email) {
        if (email == null || !email.contains(char1) || !email.contains(char2) ) {
            throw new IllegalArgumentException("Incorrect email");
        }
    }

    public void validationParameter(String name, int age, String email) {
        validationName(name);
        validationEmail(email);
        if (name.equals(email)){
            throw new IllegalArgumentException("name and email are the same");
        }
        if (age < 0 || age > 130){
            throw new IllegalArgumentException("Incorrect value for age");
        }
    }

    public void validationName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("fields should be filled");
        }
        if (name.length() < 6){
            System.out.println("name.length() < 6");
            throw new IllegalArgumentException("the number of characters must be at least 6");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }
}
