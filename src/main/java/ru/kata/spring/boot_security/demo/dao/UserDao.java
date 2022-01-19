package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteById(Long id);
    User findByUsername(String username);
}
