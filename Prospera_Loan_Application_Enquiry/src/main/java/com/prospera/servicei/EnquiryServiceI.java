package com.prospera.servicei;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.prospera.model.Enquiry;

public interface EnquiryServiceI {

	ResponseEntity<Enquiry> updateEnquiry(int enquiryID, Enquiry e);

	ResponseEntity<Enquiry> addEnquiry(Enquiry e);

	ResponseEntity<String> deleteById(int enquiryID);

	Optional<Enquiry> getEnquiryById(int enquiryID);

	List<Enquiry> getallenquiry();
	
	ResponseEntity<Enquiry> getById(int enquiryID);

	List<Enquiry> getEnquiryByLoanStatus(String loanStatus);

	List<Enquiry> getEnquiryByEnquiryStatus(String enquiryStatus);

	ResponseEntity<String> forwardToOE(int enquiryID);


}
