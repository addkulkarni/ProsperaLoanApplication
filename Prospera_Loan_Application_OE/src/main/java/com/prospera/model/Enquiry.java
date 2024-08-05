package com.prospera.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Enquiry
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquiryID;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private Long mobileNo;
	private String pancardNo;
	private String adharcardNo;
	private String gender;
	private	LocalDateTime timeStamp;
	private String loanStatus;
	private String enquiryStatus;
}