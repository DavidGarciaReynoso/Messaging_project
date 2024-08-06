package com.campaign.project.campaignproject.controller;

import com.campaign.project.campaignproject.dto.CustomerVisitDTO;
import com.campaign.project.campaignproject.entity.Customer;
import com.campaign.project.campaignproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getById(@PathVariable("customerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);
    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable("customerId") int customerId) {
        customerService.delete(customerId);
    }

    @GetMapping("/by-visit-date")
    public List<CustomerVisitDTO> getCustomersByVisitDate(@RequestParam String visitDate) {
        LocalDate date = LocalDate.parse(visitDate);
        return customerService.getCustomersByVisitDate(date);
    }
}
