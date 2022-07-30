package com.efremov.preproject311.service;

import com.efremov.preproject311.models.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    User getUser(int id);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
