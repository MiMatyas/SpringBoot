package com.matyas.Shop.db.service.impl;

import com.matyas.Shop.db.repository.BoughtProductRepository;
import com.matyas.Shop.db.service.api.BoughtProductService;
import com.matyas.Shop.domain.BoughtProduct;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoughProductServiceImpl implements BoughtProductService {

    private final BoughtProductRepository boughtProductRepository;

    public BoughProductServiceImpl(BoughtProductRepository boughtProductRepository) {
        this.boughtProductRepository = boughtProductRepository;
    }

    @Override
    public void add(BoughtProduct boughtProduct) {
        boughtProductRepository.add(boughtProduct);
    }

    @Override
    public List<BoughtProduct> getAllByCustomerId(int customerId) {
        return boughtProductRepository.getAllByCustomerId(customerId);
    }
}
