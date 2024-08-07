package com.prospera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prospera.model.Customer;
import com.prospera.model.Document;
import com.prospera.servicei.EnquiryServiceI;

@RestController
@RequestMapping("/re")
public class REController
{
	
	@Autowired
	EnquiryServiceI esi;
	
	@PostMapping("/registerCustomer/{enquiryID}")
	public ResponseEntity<String> addCustomer(@RequestBody Customer c,@PathVariable("enquiryID")int enquiryID)
	{
	
		ResponseEntity<String> response = esi.addCustomer(c,enquiryID);
		return response;
	}
	
	
//	@PostMapping("/registerCustomer/{enquiryID}")
//	public ResponseEntity<String> addCustomer(@PathVariable("enquiryID")int enquiryID,@RequestPart("data")String customer,@RequestPart("adharcard")MultipartFile adharcard,@RequestPart("pancard")MultipartFile pancard,@RequestPart("photo")MultipartFile photo,@RequestPart("sign")MultipartFile sign,@RequestPart("voterId")MultipartFile voterId,@RequestPart("incomeCertificate")MultipartFile incomeCertificate,@RequestPart("salarySlip")MultipartFile salarySlip) throws Exception
//	{
//		
//		ObjectMapper om=new ObjectMapper();
//		
//			Customer cus=om.readValue(customer, Customer.class);
//			Document d=new Document();
//			d.setAdharCard(adharcard.getBytes());
//			d.setPancard(pancard.getBytes());
//			d.setPhoto(photo.getBytes());
//			d.setSign(sign.getBytes());
//			d.setVoterId(voterId.getBytes());
//			d.setIncomeCertificate(incomeCertificate.getBytes());
//			d.setSalarySlip(salarySlip.getBytes());
//			cus.setDoc(d);
//			esi.saveData(cus);
//			ResponseEntity<String> response=new ResponseEntity<String>("data saved successfully",HttpStatus.OK);
//			return response;
//			
//		} 
//		 
//		
	}
	
	

