package com.amiri.microservice.customer.web;

import com.amiri.microservice.customer.Customer;
import com.amiri.microservice.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/{id}")
    public Customer customer(@PathVariable("id") long id) {
        return customerRepository.findById(id).get();
    }

    @RequestMapping(value = "/list")
    public Iterable<Customer> customerList() {
        return customerRepository.findAll();
    }


    @PostMapping(value = "/form")
    public Customer post(Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping(value = "/{id}")
    public Customer put(@PathVariable("id") long id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long id) {
        customerRepository.deleteById(id);
    }

}
