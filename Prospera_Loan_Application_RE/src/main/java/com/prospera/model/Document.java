package com.prospera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Document {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int did;
	private byte[] adharCard;
	private byte[] pancard;
	private byte[] photo;
	private byte[] sign;
	private byte[] voterId;
	private byte[] incomeCertificate;
	private byte[] salarySlip;
}
