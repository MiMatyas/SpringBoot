package com.matyas.Shop.db.service.impl;

import com.matyas.Shop.db.repository.MerchantRepository;
import com.matyas.Shop.db.service.api.MerchantService;
import com.matyas.Shop.db.service.api.request.UpdateMerchantRequest;
import com.matyas.Shop.domain.Merchant;

import java.util.List;

public class MerchanServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchanServiceImpl(MerchantRepository merchantRepository){
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<Merchant> getMerchants() {
        return merchantRepository.getMerchants();
    }

    @Override
    public Merchant get(int id) {
        return merchantRepository.get(id);
    }

    @Override
    public Integer add(Merchant merchant) {
        return merchantRepository.add(merchant);
    }

    @Override
    public void delete(int id) {
        merchantRepository.delete(id);
    }

    @Override
    public void update(int id, UpdateMerchantRequest updateMerchantRequest) {

    }
}
