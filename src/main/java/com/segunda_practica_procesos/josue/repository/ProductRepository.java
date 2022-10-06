package com.segunda_practica_procesos.josue.repository;

import com.segunda_practica_procesos.josue.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
