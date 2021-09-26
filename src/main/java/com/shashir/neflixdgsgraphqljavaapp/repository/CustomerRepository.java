package com.shashir.neflixdgsgraphqljavaapp.repository;

import com.shashir.neflixdgsgraphqljavaapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {}
