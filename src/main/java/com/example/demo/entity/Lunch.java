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
@Table(name = "Lunch")
public class Lunch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "lunch_seq")
	@SequenceGenerator(name = "lunch_seq" , sequenceName = "lunch_seq", allocationSize =1)
	@Column(name = "LUNCH_ID", unique = true, nullable = false)
	private Long lunchId;
	
	@Column(name = "PASSCODE")
	private String passcode;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;

	@Column(name = "FINAL_LOCATION")
	private String finalLocation;

	public Long getLunchId() {
		return lunchId;
	}

	public void setLunchId(Long lunchId) {
		this.lunchId = lunchId;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getFinalLocation() {
		return finalLocation;
	}

	public void setFinalLocation(String finalLocation) {
		this.finalLocation = finalLocation;
	}

	

	@Override
	public String toString() {
		return "Lunch [lunchId=" + lunchId + ", passcode=" + passcode + ", createdDt=" + createdDt + ", finalLocation="
				+ finalLocation + "]";
	}
	
	

	public Lunch(Long lunchId, String passcode, Date createdDt, String finalLocation) {
		super();
		this.lunchId = lunchId;
		this.passcode = passcode;
		this.createdDt = createdDt;
		this.finalLocation = finalLocation;
	}

	public Lunch() {};
	
	

}
