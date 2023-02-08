package com.matyas.Shop.db.service.api;
import com.matyas.Shop.db.service.api.request.UpdateProductRequest;
import com.matyas.Shop.domain.Product;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    @Nullable
    Product getProduct(int id);
    @Nullable
    Integer add(Product product); //id vytvori databaze a mi si ho nechame vratit

    void detele(int id); // vymaze product s danym id;

    void update(int id, UpdateProductRequest updateProductRequest); // updateProductRequest z hlavicky prepise product v databazi se zvolenym id
}
