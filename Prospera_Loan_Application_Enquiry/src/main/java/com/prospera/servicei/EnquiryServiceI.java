package com.prospera.servicei;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.prospera.model.Enquiry;

public interface EnquiryServiceI {

	ResponseEntity<Enquiry> updateEnquiry(int enquiryID, Enquiry e);

	ResponseEntity<Enquiry> addEnquiry(Enquiry e);

	ResponseEntity<String> deleteById(int enquiryID);

	Optional<Enquiry> getEnquiryById(int enquiryID);

	ResponseEntity<Enquiry> getallenquiry(Enquiry e);
	
	ResponseEntity<Enquiry> getById(int enquiryID);


}
