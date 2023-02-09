package com.matyas.Shop.db.service.impl;

import com.matyas.Shop.db.repository.CustomerRepository;
import com.matyas.Shop.db.service.api.CustomerService;
import com.matyas.Shop.db.service.api.request.UpdateCustomerRequest;
import com.matyas.Shop.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.get(id);
    }

    @Override
    public Integer add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public void update(int id, UpdateCustomerRequest updateCustomerRequest) {

        customerRepository.update(id, updateCustomerRequest);
    }
}
