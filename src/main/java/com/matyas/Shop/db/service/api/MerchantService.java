package com.matyas.Shop.db.service.api;
import com.matyas.Shop.domain.Merchant;
import org.springframework.lang.NonNull;


import java.util.List;

public interface MerchantService {
    List<Merchant> getMerchants();
    @NonNull
    Merchant get(int id);
    @NonNull
    Integer add(Merchant merchant);  //id vytvori databaze a mi si ho nechame vratit

}
