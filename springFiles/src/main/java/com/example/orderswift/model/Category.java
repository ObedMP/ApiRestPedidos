package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "Category")
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "category_id",
            updatable = false
    )
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @ManyToMany
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}