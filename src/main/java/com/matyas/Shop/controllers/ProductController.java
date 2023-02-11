package com.matyas.Shop.controllers;
import com.matyas.Shop.db.service.api.request.UpdateProductRequest;
import com.matyas.Shop.domain.Product;
import com.matyas.Shop.db.service.api.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity getAll(){
        List<Product> productList = productService.getProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        Product product = productService.getProduct(id);
        if (product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity add(@RequestBody Product product){
        Integer id = productService.add(product);
        if (id != null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody UpdateProductRequest updateProductRequest) {
        if (productService.getProduct(id) != null) {
            productService.update(id, updateProductRequest);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Produkt s id "+id+" neexistuje");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
            if (productService.getProduct(id) != null) {
                productService.detele(id);
                return ResponseEntity.ok().build();
            }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Produkt s id "+id+" neexistuje");
    }
}
