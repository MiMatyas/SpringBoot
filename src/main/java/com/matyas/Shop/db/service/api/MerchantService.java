package com.matyas.Shop.db.service.api;
import com.matyas.Shop.domain.Merchant;
import org.springframework.lang.NonNull;
import com.matyas.Shop.db.service.api.request.UpdateMerchantRequest;

import java.util.List;

public interface MerchantService {
    List<Merchant> getMerchants();
    @NonNull
    Merchant get(int id);
    @NonNull
    Integer add(Merchant merchant);  //id vytvori databaze a mi si ho nechame vratit
    void delete(int id);  // vymaze product s danym id;
    void update(int id, UpdateMerchantRequest updateMerchantRequest); // updateMerchantRequest z hlavicky prepise merchanta v databazi se zvolenym id
}
