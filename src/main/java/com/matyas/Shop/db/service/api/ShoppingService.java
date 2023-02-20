package com.matyas.Shop.db.service.api;

import com.matyas.Shop.db.service.api.request.BuyProductRequest;
import com.matyas.Shop.db.service.api.response.BuyProductResponse;

public interface ShoppingService {
    BuyProductResponse buyProduct(BuyProductRequest request);
}
