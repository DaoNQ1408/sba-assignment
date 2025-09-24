package com.daoqonq1408.workshopbesql.service;

import com.daoqonq1408.workshopbesql.model.Role;
import com.daoqonq1408.workshopbesql.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public Role addRole(Role role) {
        Role roleTemp = roleRepository.findByRoleName(role.getRoleName());
        if(roleTemp == null){
            return roleRepository.save(role);
        }
        return roleTemp;
    }

    @Override
    public Role updateRole(Role role) {
        Role roleTemp = roleRepository.findById(role.getRoleId()).orElse(null);
        if(roleTemp != null){
            roleTemp.setRoleName(role.getRoleName());
        }
        return roleRepository.save(roleTemp);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRoleById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
