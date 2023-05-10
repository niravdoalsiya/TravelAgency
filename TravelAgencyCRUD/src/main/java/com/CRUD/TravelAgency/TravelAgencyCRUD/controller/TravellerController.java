package com.CRUD.TravelAgency.TravelAgencyCRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.TravelAgency.TravelAgencyCRUD.entity.Travellers;
import com.CRUD.TravelAgency.TravelAgencyCRUD.service.TravellersService;
import com.TravelAgency.TravelAgency.model.Customers;

import jakarta.validation.Valid;

@RestController
public class TravellerController {
	
	@Autowired
	private TravellersService service;
	
	//post mapping
		// add traveller by id
	
	@PostMapping("/travellagency")
	private ResponseEntity<List<Travellers>> addTravellers(@Valid @RequestBody Travellers travellers) {
		 Travellers addTravellers = this.service.addTravellers(travellers);
		 return new ResponseEntity <List<Travellers>> (HttpStatus.CREATED);
	}
	
	//get mapping
	// get all traveller 
	
	@GetMapping("/travellagency")
	private List<Travellers>getAllTravellers() {
		return this.service.getAllTravellers();
	}
	
	//get mapping by id 
	// get traveller by id 
	
	@GetMapping("/travellagency/{travellerid}")
	private ResponseEntity<Object> getSingleTraveller(@PathVariable Integer travellerid) {
		return ResponseEntity.ok(this.service.getTravellersById(travellerid));
	}
	
		
	//put mapping by id 
	// put traveller by id 
	
	@PutMapping("/travellagency/{travellerid}")
	private ResponseEntity<HttpStatus> updateTravellersById(@Valid @PathVariable Integer travellerid,@RequestBody Travellers travellers) {
		ResponseEntity<Travellers> updateTravellers = this.service.updateTravellers(travellerid,travellers);
		this.service.updateTravellers(travellerid, travellers);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	
	//delete mapping by id 
	//delete traveller by id 
	
	
	@DeleteMapping("/delete/travellagency/{travellerid}")
	private ResponseEntity<Travellers> deleteTravellers( @PathVariable Integer travellerid) {
		 this.service.deleteTravellersById(travellerid);
		 return new ResponseEntity<Travellers> (HttpStatus.ACCEPTED);
	}

}


