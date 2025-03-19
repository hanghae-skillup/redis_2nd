package com.module.redis2nd.domain.customer.repository;

import com.module.redis2nd.domain.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
