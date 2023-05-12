package com.CRUD.TravelAgency.TravelAgencyCRUD.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CRUD.TravelAgency.TravelAgencyCRUD.dao.TravellerRepository;
import com.CRUD.TravelAgency.TravelAgencyCRUD.entity.Travellers;

@SpringBootTest
public class repoTest {
	
	//@MockBean
	//private TravellersService service;
	
	@Autowired
	private TravellerRepository repository;
	
	
	//create the user and match with given id 
	
	@Test
	public void testCreate() {
		
		Travellers traveller = new Travellers();
		traveller.setTravellerid(3);
		traveller.setFirst_name("Tushar");
		traveller.setLast_name("Tank");
		traveller.setStarting_location("Ambegaon");
		traveller.setDestination_location("Australiya");
		traveller.setLocation_covered("5");
		traveller.setPackage_name("Buisness");
		traveller.setCost(150000f);
		traveller.setPermanent_address("Pune");
		traveller.setCommunication_address("Sydney");
		traveller.setPhone("8600035119");
		traveller.setNotes("Welcome To TraveAgency");
		this.repository.save(traveller);
		
		assertNotNull(this.repository.findById(3).get());
	}

	//test read by id
	
	@Test
	public void testReadById() {
		
		Travellers traveller = this.repository.findById(3).get();
		assertEquals("Mirani", traveller.getLast_name());
	}
	
	//test update by id
	
	@Test
	public void testUpdateById() {
		
		Travellers traveller = this.repository.findById(3).get();
		traveller.setFirst_name("HARSH");
		this.repository.save(traveller);
		assertNotEquals("harsh", this.repository.findById(3).get().getFirst_name());
	}
	
	//test delete by id 
	
	@Test
	public void testDeleteById() {
		
		this.repository.deleteById(3);
		assertThat(this.repository.existsById(3)).isFalse();
	}
	

}
