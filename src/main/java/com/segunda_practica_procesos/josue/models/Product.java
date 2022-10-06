package com.segunda_practica_procesos.josue.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name_product;
    @Column(length = 100, nullable = false)
    private String type_product;
    @Column(length = 500)
    private String description;
}
