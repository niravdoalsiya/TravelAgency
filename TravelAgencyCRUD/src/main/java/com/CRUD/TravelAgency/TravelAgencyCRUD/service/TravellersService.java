package com.CRUD.TravelAgency.TravelAgencyCRUD.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.apache.catalina.startup.Tomcat.ExistingStandardWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.CRUD.TravelAgency.TravelAgencyCRUD.dao.TravellerRepository;
import com.CRUD.TravelAgency.TravelAgencyCRUD.entity.Travellers;
import com.TravelAgency.TravelAgency.model.Customers;

import jakarta.persistence.criteria.Path;
//import com.TravelAgency.TravelAgency.model.Customers;

@Service
public class TravellersService {

	@Autowired
	private TravellerRepository repository;
	
	public Travellers addTravellers(Travellers travellers) {
		return this.repository.save(travellers);
	}

	public List<Travellers> getAllTravellers() {
		return this.repository.findAll();
	}
	
	public Object getTravellersById(Integer travellerid) {
		return this.repository.findById(travellerid);
	}
	
	
	public ResponseEntity<Travellers> updateTravellers(Integer travellerid, Travellers travellers) {
		Optional<Travellers> traveller = this.repository.findById(travellerid);
		if(traveller.isPresent()) {
			Travellers existtravellers = traveller.get();
			existtravellers.setFirst_name(travellers.getFirst_name());
			existtravellers.setLast_name(travellers.getLast_name());
			existtravellers.setStarting_location(travellers.getStarting_location());
			existtravellers.setDestination_location(travellers.getDestination_location());
			existtravellers.setLocation_covered(travellers.getLocation_covered());
			existtravellers.setPackage_name(travellers.getPackage_name());
			existtravellers.setCost(travellers.getCost());
			existtravellers.setPermanent_address(travellers.getPermanent_address());
			existtravellers.setCommunication_address(travellers.getCommunication_address());
			existtravellers.setPhone(travellers.getPhone());
			existtravellers.setNotes(travellers.getNotes());	
			this.repository.save(existtravellers);
			return new ResponseEntity<Travellers>(existtravellers,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Travellers>(HttpStatus.NOT_ACCEPTABLE);
			//return this.repository.findById(travellerid);
		}
		}
/*	customersRepository.save(existCust);
	return new  ResponseEntity<Customers>(existCust,HttpStatus.CREATED);
	}else {
	return new ResponseEntity<Customers>(HttpStatus.NOT_ACCEPTABLE);
}*/
	
	public Travellers deleteTravellersById(Integer travellerid) {
		this.repository.deleteById(travellerid);
		return null ;
	}

	

	

	

	

	

	


	}

	

	
	
	

	

	


	
	
	
	
	

