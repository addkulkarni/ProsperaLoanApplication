package com.prospera.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prospera.model.Enquiry;
import com.prospera.servicei.EnquiryServiceI;


@RestController
public class EnquiryController {
	
	@Autowired
	EnquiryServiceI esi;
	
	@PutMapping("updateenquiry/{enquiryID}")
	public ResponseEntity<Enquiry> updateEnquiry(@PathVariable("enquiryID")int enquiryID, @RequestBody Enquiry e)
	{
		ResponseEntity<Enquiry> response = esi.updateEnquiry(enquiryID, e);
		return response;
	}
	
	@PostMapping("addenquiry")
	public ResponseEntity<Enquiry> addEnquiry(@RequestBody Enquiry e)
	{
		ResponseEntity<Enquiry> response = esi.addEnquiry(e);
		return response;
	}
	
	@DeleteMapping("deletebyid/{enquiryID}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable("enquiryID")int enquiryID)
	{
		Optional<Enquiry> o = esi.getEnquiryById(enquiryID);
		if(o.isPresent())
		{
			ResponseEntity<String> response = esi.deleteById(enquiryID);
			return response;
		}
		else
		{
			throw new EnquiryIdNotFoundException("Id not found");
		}
	}
}
