package com.daoqonq1408.workshopbesql.service;

import com.daoqonq1408.workshopbesql.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    public Role findByRoleName(String name);
    public Role addRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(int id);
    public Role getRoleById(int id);
    public List<Role> getRoles();
}
