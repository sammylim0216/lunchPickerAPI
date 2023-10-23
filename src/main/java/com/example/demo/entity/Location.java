package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import jakarta.persistence.GenerationType;

@Entity
@Table(name = "LUNCH_LOCATION")
public class Location implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "lunch_location_seq")
	@SequenceGenerator(name = "lunch_location_seq" , sequenceName = "lunch_location_seq", allocationSize =1)
	@Column(name = "LOCATION_ID", unique = true, nullable = false)
	private Long locationId;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;

	@Column(name = "LUNCH_ID")
	private Long lunchId;

	

	public Long getLocationId() {
		return locationId;
	}



	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Date getCreatedDt() {
		return createdDt;
	}



	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}



	public Long getLunchId() {
		return lunchId;
	}



	public void setLunchId(Long lunchId) {
		this.lunchId = lunchId;
	}

	

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", location=" + location + ", createdDt=" + createdDt
				+ ", lunchId=" + lunchId + "]";
	}



	public Location(Long locationId, String location, Date createdDt, Long lunchId) {
		super();
		this.locationId = locationId;
		this.location = location;
		this.createdDt = createdDt;
		this.lunchId = lunchId;
	}



	public Location() {};
	
	

}
