package com.daoqonq1408.workshopbesql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private long id;

    @Column(name = "mail", length = 100, unique = true, nullable = false)
    private String mail;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @OneToOne(mappedBy = "account")
    private Teacher teacher;
}
