package com.example.ecom_backend.controller;

import com.example.ecom_backend.model.Product;
import com.example.ecom_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>>  getProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK) ;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product>  getProductById(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product.getName()!= null)
        {
            return new ResponseEntity<>(product, HttpStatus.OK) ;
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product savedProduct = null;
        try {
            savedProduct = service.addProduct(product,imageFile);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);

        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId)
    {
        Product product = service.getProductById(productId);
        return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);

    }

}
