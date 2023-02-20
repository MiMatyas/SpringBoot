package com.matyas.Shop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matyas.Shop.db.service.api.request.UpdateProductRequest;
import com.matyas.Shop.domain.Customer;
import com.matyas.Shop.domain.Merchant;
import com.matyas.Shop.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class RestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Merchant merchant;
    @BeforeEach // tvorime merchanta before aby pri testu productu uz existoval nejaky merchant a tedy i merchant.id
    public void createMerchant() throws Exception {
        if (merchant == null) {
            merchant = new Merchant("Adam","novak@seznam.cz","Brno","horni",47,63901);
            String id = mockMvc.perform(post("/merchant")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(merchant)))
                    .andExpect(status().isCreated())
                    .andReturn().getResponse().getContentAsString();
            merchant.setId(objectMapper.readValue(id, Integer.class));
        }
    }
    @Test
    public void product() throws Exception{
        Product product = new Product(merchant.getId(),"Klavesnice","super tenka",149,10);
        // add product
        String id = mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        product.setId(objectMapper.readValue(id, Integer.class));
        //get product
        String productJson = mockMvc.perform(get("/product/"+product.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Product returnedProduct = objectMapper.readValue(productJson, Product.class);
        Assertions.assertEquals(product,returnedProduct);
        // get all products
        String ReturnedProducts = mockMvc.perform(get("/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Product> productList = objectMapper.readValue(ReturnedProducts, new TypeReference<List<Product>>() {});
        assert productList.size() == 1;
        Assertions.assertEquals(product,productList.get(0));
        // update product
        double updatePrice = product.getPrice()+50;
        int updateAvailable = product.getAvailable()+5;
        UpdateProductRequest updateProductRequest = new UpdateProductRequest(product.getName(),product.getDescription(),updatePrice,updateAvailable);

        mockMvc.perform(patch("/product/"+product.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateProductRequest)))
                .andExpect(status().isOk());
        String productUpdatedJson = mockMvc.perform(get("/product/"+product.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Product updateProduct = objectMapper.readValue(productUpdatedJson, Product.class);
        assert updatePrice == updateProduct.getPrice();
        assert updateAvailable == updateProduct.getAvailable();
        // delete product
        mockMvc.perform(delete("/product/"+product.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/product/"+product.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        String ReturnedProducts2 = mockMvc.perform(get("/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Product> productList2 = objectMapper.readValue(ReturnedProducts2, new TypeReference<List<Product>>() {});

        assert productList2.size() == 0;



    }
    @Test
    public void customer() throws Exception {
        Customer customer = new Customer("Adam", "Novak", "adam.novak@seznam.cz", "Praha", "Dolni", 5, 61101, 25, 777777777);
        // add customer
        String id = mockMvc.perform(post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        customer.setId(objectMapper.readValue(id, Integer.class));
        // get customer
        String customerJson = mockMvc.perform(get("/customer/" + customer.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Customer returnedCustomer = objectMapper.readValue(customerJson, Customer.class);
        Assertions.assertEquals(customer.toString(), returnedCustomer.toString());
        //get all customers
        String listJson = mockMvc.perform(get("/customer")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Customer> customers = objectMapper.readValue(listJson, new TypeReference<List<Customer>>(){});
        assert customers.size() == 1;
        Assertions.assertEquals(customer.toString(),customers.get(0).toString());
    }
        @Test
        public void merchant() throws Exception{
        // Merchant is already created by @BeforeEach


        // get merchant
        String merchantJson = mockMvc.perform(get("/merchant/"+merchant.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Merchant returnedMerchant = objectMapper.readValue(merchantJson, Merchant.class);
        Assertions.assertEquals(merchant,returnedMerchant);
        // get all merchants
        String listMerchants = mockMvc.perform(get("/merchant")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Merchant> merchants = objectMapper.readValue(listMerchants, new TypeReference<List<Merchant>>() {});
        assert merchants.size() == 1;
        Assertions.assertEquals(merchant,merchants.get(0));
        }

}
