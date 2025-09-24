package com.daoqonq1408.workshopbesql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "category_name", nullable = false,unique = true, length = 100)
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books = new ArrayList<>();
}
