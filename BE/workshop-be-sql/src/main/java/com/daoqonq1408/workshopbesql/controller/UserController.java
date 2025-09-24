package com.daoqonq1408.workshopbesql.controller;

import com.daoqonq1408.workshopbesql.model.Role;
import com.daoqonq1408.workshopbesql.model.User;
import com.daoqonq1408.workshopbesql.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
@Tag(name = "User Management", description = "APIs for managing user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }
}
