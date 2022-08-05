package com.efremov.preproject311.service;

import com.efremov.preproject311.dao.UserDao;
import com.efremov.preproject311.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void saveNew(User user) {
        userDao.saveNew(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.update(user);
    }


    @Override
    public User getUserById(int id) {
        return userDao.getById(id);
    }


    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.delete(id);
    }
}
