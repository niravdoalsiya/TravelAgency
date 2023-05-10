package com.CRUD.TravelAgency.TravelAgencyCRUD.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Travellers")
public class Travellers {
	
//	travellerid`      			int NOT NULL AUTO_INCREMENT,
//	`first_name`     			varchar(20) DEFAULT NULL,
//	`last_name` 				varchar(20) DEFAULT NULL,
//	`starting_location` 		varchar(100) DEFAULT NULL,
//	`destination_location` 		varchar(100) DEFAULT NULL,
//	 `location_covered` 		varchar(20) DEFAULT NULL,
//	`package_name` 				varchar(50) DEFAULT NULL,
//	`cost` 						float not NULL,
//	`permanent_address` 		varchar(250) DEFAULT NULL,
//	`communication_address` 	varchar(250) DEFAULT NULL,
//	`phone` 					varchar(10) DEFAULT NULL,
//	`notes` 					varchar(50) DEFAULT NULL,
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer travellerid;
	
	@Column//(name="first_name")
	private String first_name;
	
	@Column//(name="last_name")
	private String last_name;
	
	@Column//(name="starting_location")
	private String starting_location;
	
	@Column//(name="destination_location")
	private String destination_location;
	
	@Column//(name="location_covered")
	private String location_covered;
	
	@Column//(name="package_name")
	private String package_name;
	
	@Column//(name="cost")
	private Float cost;
	
	@Column//(name="permanent_address")
	private String permanent_address;
	
	@Column//(name="communication_address")
	private String communication_address;
	
	@Column//(name="phone")
	@NotEmpty
	@Size(min=10,message="Phone Number Is Invalid :(  Must Have 10 Digits ")
	@Pattern(regexp= "^(\\+\\d{1,3}( )?)?\\d{10}$")
	private String phone;
	
	@Column//(name="notes")
	private String notes;

	

	/**
	 * @return the travellerid
	 */
	public Integer getTravellerid() {
		return this.travellerid;
	}

	/**
	 * @param travellerid the travellerid to set
	 */
	public void setTravellerid(Integer travellerid) {
		this.travellerid = travellerid;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return this.first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return this.last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the starting_location
	 */
	public String getStarting_location() {
		return this.starting_location;
	}

	/**
	 * @param starting_location the starting_location to set
	 */
	public void setStarting_location(String starting_location) {
		this.starting_location = starting_location;
	}

	/**
	 * @return the destination_location
	 */
	public String getDestination_location() {
		return this.destination_location;
	}

	/**
	 * @param destination_location the destination_location to set
	 */
	public void setDestination_location(String destination_location) {
		this.destination_location = destination_location;
	}

	/**
	 * @return the location_covered
	 */
	public String getLocation_covered() {
		return this.location_covered;
	}

	/**
	 * @param location_covered the location_covered to set
	 */
	public void setLocation_covered(String location_covered) {
		this.location_covered = location_covered;
	}

	/**
	 * @return the package_name
	 */
	public String getPackage_name() {
		return this.package_name;
	}

	/**
	 * @param package_name the package_name to set
	 */
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	/**
	 * @return the cost
	 */
	public Float getCost() {
		return this.cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Float cost) {
		this.cost = cost;
	}

	/**
	 * @return the permanent_address
	 */
	public String getPermanent_address() {
		return this.permanent_address;
	}

	/**
	 * @param permanent_address the permanent_address to set
	 */
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	/**
	 * @return the communication_address
	 */
	public String getCommunication_address() {
		return this.communication_address;
	}

	/**
	 * @param communication_address the communication_address to set
	 */
	public void setCommunication_address(String communication_address) {
		this.communication_address = communication_address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return this.notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Travellers(Integer travellerid, String first_name, String last_name, String starting_location,
			String destination_location, String location_covered, String package_name, Float cost,
			String permanent_address, String communication_address, String phone, String notes) {
		this.travellerid = travellerid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.starting_location = starting_location;
		this.destination_location = destination_location;
		this.location_covered = location_covered;
		this.package_name = package_name;
		this.cost = cost;
		this.permanent_address = permanent_address;
		this.communication_address = communication_address;
		this.phone = phone;
		this.notes = notes;
	}
	
	public Travellers() {
		super();
	}

	@Override
	public String toString() {
		return "Travellers [travellerid=" + this.travellerid + ", first_name=" + this.first_name + ", last_name=" + this.last_name
				+ ", starting_location=" + this.starting_location + ", destination_location=" + this.destination_location
				+ ", location_covered=" + this.location_covered + ", package_name=" + this.package_name + ", cost=" + this.cost
				+ ", permanent_address=" + this.permanent_address + ", communication_address=" + this.communication_address
				+ ", phone=" + this.phone + ", notes=" + this.notes + "]";
	}

	
	

}
