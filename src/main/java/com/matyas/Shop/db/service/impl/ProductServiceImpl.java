package com.matyas.Shop.db.service.impl;

import com.matyas.Shop.db.repository.ProductRepository;
import com.matyas.Shop.db.service.api.ProductService;
import com.matyas.Shop.db.service.api.request.UpdateProductRequest;
import com.matyas.Shop.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    @Override
    public Integer add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public void detele(int id) {
        productRepository.delete(id);
    }

    @Override
    public void update(int id, UpdateProductRequest updateProductRequest) {
        productRepository.update(id, updateProductRequest);
    }

    @Override
    public void updateAvailableInternal(int id, int newAvailable) {
        productRepository.updateAvailable(id, newAvailable);
    }


}
