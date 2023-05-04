package com.TravelAgency.TravelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelAgency.TravelAgency.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers,Long> {

}
