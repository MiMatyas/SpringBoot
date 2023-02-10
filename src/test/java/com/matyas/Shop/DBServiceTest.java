package com.matyas.Shop;

import com.matyas.Shop.db.service.api.CustomerService;
import com.matyas.Shop.db.service.api.MerchantService;
import com.matyas.Shop.domain.Customer;
import com.matyas.Shop.domain.Merchant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import org.junit.jupiter.api.Assertions;


import java.util.List;
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DBServiceTest {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MerchantService merchantService;

    private static Merchant merchant;
//    @BeforeEach
//    public void createMerchant() {
//        if (merchant == null) {
//            merchant = new Merchant("Jakub", "Jakub@seznam.cz", "Brno", "Dolni", 5, 63902);
//            Integer id = merchantService.add(merchant);
//            assert id != null;
//            merchant.setId(id);
//        }
//    }
    @Test
    public void customer() {
        Customer customer = new Customer("Adam", "Novak", "adam.novak@seznam.cz", "Praha", "Brněnská", 5, 61101, 25, 732358465);
        Integer id = customerService.add(customer);
        assert id != null;
        customer.setId(id);

        Customer customerTest = customerService.getCustomer(id);
        Assertions.assertEquals(customer.toString(), customerTest.toString());

        List<Customer> customers = customerService.getCustomers();
        Assertions.assertEquals(1, customers.size());
        Assertions.assertEquals(customer.toString(), customers.get(0).toString());
    }


    @Test
    public void merchant() {
        Merchant merchant = new Merchant("Jakub", "Jakub@seznam.cz", "Brno", "Dolni", 5, 63902);
        Integer id = merchantService.add(merchant);
        assert id != null;
        merchant.setId(id);
        Assertions.assertEquals(1, id);
        Merchant merchantTest = merchantService.get(id);
        Assertions.assertEquals(merchant,merchantTest);
        List<Merchant> Merchants = merchantService.getMerchants();
        Assertions.assertEquals(1,Merchants.size());
        Assertions.assertEquals(merchant,Merchants.get(0));


    }

}
