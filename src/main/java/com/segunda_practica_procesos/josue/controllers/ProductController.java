package com.segunda_practica_procesos.josue.controllers;

import com.segunda_practica_procesos.josue.models.Product;
import com.segunda_practica_procesos.josue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
@Autowired
    private ProductRepository productRepository;
    @GetMapping(value = "/products/{id}")
    public ResponseEntity getProducts(@PathVariable Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return new ResponseEntity(product, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product product){
        try{
            productRepository.save(product);
            return new ResponseEntity(product, HttpStatus.CREATED);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/listProducts")
    public ResponseEntity listProducts(){
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity(products, HttpStatus.OK);
        }
    }
    @PutMapping(value = "/product/{id}")
    public ResponseEntity editProduct(@PathVariable Long id, @RequestBody Product product){
        Optional<Product> productBD = productRepository.findById(id);
        if(productBD.isPresent()){
            try{
                productBD.get().setName_product(product.getName_product());
                productBD.get().setType_product(product.getType_product());
                productBD.get().setDescription(product.getDescription());
                productRepository.save(productBD.get());
            }catch(Exception e){
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping(value = "/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        Optional<Product> productBD = productRepository.findById(id);
        if(productBD.isPresent()){
            productRepository.delete(productBD.get());
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
