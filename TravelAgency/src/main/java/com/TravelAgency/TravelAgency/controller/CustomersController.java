package com.TravelAgency.TravelAgency.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TravelAgency.TravelAgency.model.Customers;
import com.TravelAgency.TravelAgency.repository.CustomersRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CustomersController {
	
	@Autowired
	CustomersRepository customersRepository;

	@PostMapping("/travelagency")
	public ResponseEntity<List<Customers>> createNewCustomers(@Valid @RequestBody Customers customers) {
	customersRepository.save(customers);
	return new ResponseEntity<List<Customers>>(HttpStatus.CREATED);
	}

	@GetMapping("/travelagency")
	public ResponseEntity<List<Customers>> getAllCustomers(){
		
		List<Customers> custList = new ArrayList<>();
		customersRepository.findAll().forEach(custList::add);
		return new ResponseEntity<List<Customers>>(custList, HttpStatus.OK);
	}																									
	
	@GetMapping("/travelagency/{cust_id}")
	public ResponseEntity<Customers> getCustomersById(@PathVariable Long cust_id){
		Optional<Customers> cust = customersRepository.findById(cust_id);
		if(cust.isPresent()){
			return new  ResponseEntity<Customers>(cust.get(),HttpStatus.OK);
		}else {
		   return new ResponseEntity<Customers>(HttpStatus.NOT_FOUND);
		}
	}

	
	@PutMapping("/travelagency/{cust_id}")
	public ResponseEntity<Customers> updateCistomersById(@Valid @PathVariable long cust_id, @RequestBody Customers customers) {
		Optional<Customers> cust = customersRepository.findById(cust_id);
		if(cust.isPresent()) {
			Customers existCust = cust.get();
			existCust.setFirst_name(customers.getFirst_name());
			existCust.setLast_name(customers.getLast_name());
			existCust.setStarting_location(customers.getStarting_location());
			existCust.setDestination_location(customers.getDestination_location());
			existCust.setLocation_covered(customers.getLocation_covered());
			existCust.setPackage_name(customers.getPackage_name());
			existCust.setCost(customers.getCost());
			existCust.setPermanent_address(customers.getPermanent_address());
			existCust.setCommunication_address(customers.getCommunication_address());
			existCust.setPhone(customers.getPhone());
			existCust.setNotes(customers.getNotes());
			customersRepository.save(existCust);
			return new  ResponseEntity<Customers>(existCust,HttpStatus.CREATED);
			}else {
			return new ResponseEntity<Customers>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
		
	
	    	@DeleteMapping("/travelagency/{cust_id}")
	    		public ResponseEntity<Customers> deleteCustomerById(@PathVariable Long cust_id) {
	    			
	    		customersRepository.deleteById(cust_id);
	    		
	    		return new ResponseEntity<Customers>(HttpStatus.ACCEPTED);
	    		
	    	}
		
		
	}


