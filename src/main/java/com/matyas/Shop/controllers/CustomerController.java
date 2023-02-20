package com.matyas.Shop.controllers;

import com.matyas.Shop.db.service.api.CustomerAccountService;
import com.matyas.Shop.db.service.api.CustomerService;
import com.matyas.Shop.domain.Customer;
import com.matyas.Shop.domain.CustomerAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerAccountService customerAccountService;

    public CustomerController(CustomerService customerService, CustomerAccountService customerAccountService) {
        this.customerService = customerService;
        this.customerAccountService = customerAccountService;
    }


    @GetMapping()
    public ResponseEntity getAll() {
        List<Customer> customerList = customerService.getCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") int id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Customer customer) {
        Integer id = customerService.add(customer);
        if (id != null) {
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/account")
    public ResponseEntity addAccount (@RequestBody CustomerAccount customerAccount){
        customerAccountService.addCustomerAccount(customerAccount);
        return new ResponseEntity<>(null,HttpStatus.CREATED);
    }
}
