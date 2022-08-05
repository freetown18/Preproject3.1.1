package com.efremov.preproject311.service;

import com.efremov.preproject311.models.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void saveNew(User user);
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
