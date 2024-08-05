package com.prospera.servicei;

import org.springframework.http.ResponseEntity;

public interface EnquiryServiceI
{

	ResponseEntity<String> calculateCibil(int enquiryID);
	
	

}
