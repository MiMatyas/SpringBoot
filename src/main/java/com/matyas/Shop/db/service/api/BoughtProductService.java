package com.matyas.Shop.db.service.api;

import com.matyas.Shop.domain.BoughtProduct;

import java.util.List;

public interface BoughtProductService {
    void add (BoughtProduct boughtProduct);

    List<BoughtProduct> getAllByCustomerId(int customerId);
}
