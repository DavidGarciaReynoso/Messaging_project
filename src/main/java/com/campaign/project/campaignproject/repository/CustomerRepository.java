package com.campaign.project.campaignproject.repository;

import com.campaign.project.campaignproject.dto.CustomerVisitDTO;
import com.campaign.project.campaignproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT new com.campaign.project.campaignproject.dto.CustomerVisitDTO(c.customer_name, c.phone, i.invoiceDate) " +
            "FROM Invoice i " +
            "LEFT JOIN Customer c ON c.customer_id = i.customerId " +
            "WHERE i.invoiceDate = :visitDate")
    List<CustomerVisitDTO> findCustomersByVisitDate(@Param("visitDate") LocalDate visitDate);
}