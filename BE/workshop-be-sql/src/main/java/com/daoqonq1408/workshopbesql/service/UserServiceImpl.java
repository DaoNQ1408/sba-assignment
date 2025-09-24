package com.daoqonq1408.workshopbesql.service;

import com.daoqonq1408.workshopbesql.model.User;
import com.daoqonq1408.workshopbesql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User addUser(User user) {
        User userTemp = userRepository.findByUsername(user.getUsername());
        if (userTemp != null) {
            return userTemp;
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userTemp = userRepository.findById(user.getUserId()).orElse(null);
        if (userTemp != null) {
            userTemp.setUsername(user.getUsername());
            userTemp.setPassword(user.getPassword());
            userTemp.setRole(user.getRole());
            return userRepository.save(userTemp);
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
