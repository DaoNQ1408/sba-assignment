package com.daoqonq1408.workshopbesql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(name = "role_name", nullable = false, length = 50, unique = true)
    private String roleName;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<User> users = new ArrayList<>(); // set: kh trùng
}
