package com.CRUD.TravelAgency.TravelAgencyCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.TravelAgency.TravelAgencyCRUD.entity.Travellers;

public interface TravellerRepository extends JpaRepository<Travellers,Integer> {

}
