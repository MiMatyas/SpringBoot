package com.matyas.Shop.db.service.api;
import com.matyas.Shop.db.service.api.request.UpdateCustomerRequest;
import com.matyas.Shop.domain.Customer;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;


public interface CustomerService {
    List<Customer> getCustomers();
    @Nullable
    Customer getCustomer(int id);
    @NonNull
    Integer add(Customer customer);  //id vytvori databaze a mi si ho nechame vratit

    void delete(int id);  // vymaze product s danym id;

    void update(int id, UpdateCustomerRequest updateCustomerRequest); // updateCustomerRequest z hlavicky prepise customera v databazi se zvolenym id
}
