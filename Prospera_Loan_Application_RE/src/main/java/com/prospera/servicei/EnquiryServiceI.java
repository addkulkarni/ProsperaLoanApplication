package com.prospera.servicei;

import org.springframework.http.ResponseEntity;

import com.prospera.model.Customer;

public interface EnquiryServiceI
{

	ResponseEntity<String> addCustomer(Customer c,int enquiryID);

	


}
