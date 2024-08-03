package com.prospera.servicei;

import org.springframework.http.ResponseEntity;

import com.prospera.model.Enquiry;

public interface EnquiryServiceI {

	ResponseEntity<Enquiry> updateEnquiry(int enquiryID, Enquiry e);

	ResponseEntity<Enquiry> addEnquiry(Enquiry e);

}
