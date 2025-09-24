package com.daoqonq1408.workshopbesql.controller;

import com.daoqonq1408.workshopbesql.model.Role;
import com.daoqonq1408.workshopbesql.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin
@Tag(name = "Role Management", description = "APIs for managing role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<?> getRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getRolesByUserId(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(roleService.getRoleById(userId));
    }

    @PostMapping("/")
    public ResponseEntity<?> addRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.addRole(role));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteRole(@PathVariable("userId") int userId) {
        roleService.deleteRole(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<?> updateRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.updateRole(role));
    }
}
