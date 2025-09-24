package com.daoqonq1408.workshopbesql.service;

import com.daoqonq1408.workshopbesql.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User findByUsername(String username);
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public List<User> getAllUsers();
}
