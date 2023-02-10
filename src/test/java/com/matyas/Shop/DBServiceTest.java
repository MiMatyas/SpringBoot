package com.matyas.Shop;

import com.matyas.Shop.db.service.api.CustomerService;
import com.matyas.Shop.db.service.api.MerchantService;
import com.matyas.Shop.db.service.api.ProductService;
import com.matyas.Shop.db.service.api.request.UpdateProductRequest;
import com.matyas.Shop.domain.Customer;
import com.matyas.Shop.domain.Merchant;
import com.matyas.Shop.domain.Product;
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
    @Autowired
    private ProductService productService;

    private Merchant merchant;
    @BeforeEach // tvorime merchanta before aby pri testu productu uz existoval nejaky merchant a tedy i merchant.id
    public void createMerchant() {
        if (merchant == null) {
            merchant = new Merchant("Filip", "Filip@seznam.cz", "Brno", "Horni", 55, 61902);
            Integer id = merchantService.add(merchant);
            assert id != null;
            merchant.setId(id);
        }
    }
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
        // Merchant je uz vytvoreny s anotaci before

        Merchant merchantTest = merchantService.get(merchant.getId());
        Assertions.assertEquals(merchant,merchantTest);
        List<Merchant> Merchants = merchantService.getMerchants();
        Assertions.assertEquals(1,Merchants.size());
        Assertions.assertEquals(merchant,Merchants.get(0));
    }
    @Test
    public void product(){
        Product product = new Product(merchant.getId(),"Krem","Hezky kremuje",149.9,5);
        Integer id = productService.add(product);
        assert id != null;
        product.setId(id);

        Assertions.assertEquals(1, id);
        Product productTest = productService.getProduct(id);
        Assertions.assertEquals(product, productTest);

        List<Product> products = productService.getProducts();
        Assertions.assertEquals(1,products.size());
        Assertions.assertEquals(product, products.get(0));

        product.setAvailable(10);
        UpdateProductRequest updateProductRequest = new UpdateProductRequest(product.getName(),product.getDescription(),product.getPrice(),product.getAvailable());

        productService.update(1,updateProductRequest);
        Product productTestAfterUpdate = productService.getProduct(id);
        Assertions.assertEquals(product, productTestAfterUpdate);
        Assertions.assertNotEquals(productTest,productTestAfterUpdate);
        productService.detele(id);
        Assertions.assertEquals(0,productService.getProducts().size());
    }

}
