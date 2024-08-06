package com.campaign.project.campaignproject.service;

import com.campaign.project.campaignproject.dto.CustomerVisitDTO;
import com.campaign.project.campaignproject.entity.Customer;
import com.campaign.project.campaignproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(int id) {
        return customerRepository.findById(id);
    }

    public void saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerVisitDTO> getCustomersByVisitDate(LocalDate visitDate) {
        return customerRepository.findCustomersByVisitDate(visitDate);
    }
}
