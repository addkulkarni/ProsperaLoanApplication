package com.prospera.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prospera.model.Enquiry;
import com.prospera.repository.EnquiryRepository;
import com.prospera.servicei.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI{

	@Autowired
	EnquiryRepository er;
	
	@Override
	public ResponseEntity<Enquiry> updateEnquiry(int enquiryID, Enquiry e)
	{
		er.save(e);
		ResponseEntity<Enquiry> response = new ResponseEntity<Enquiry>(HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<Enquiry> addEnquiry(Enquiry e)
	{
		er.save(e);
		System.out.println(e.getEmail());
		System.out.println(e.getEnquiryID());
		System.out.println(e.getEnquiryStatus());
		ResponseEntity<Enquiry> response = new ResponseEntity<Enquiry>(e,HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<String> deleteById(int enquiryID)
	{
		er.deleteById(enquiryID);
		ResponseEntity<String> response = new ResponseEntity<String>("Enquiry deleted succesffuly", HttpStatus.OK);
		return response;
	}

	@Override
	public Optional<Enquiry> getEnquiryById(int enquiryID)
	{
		Optional<Enquiry> o = er.findById(enquiryID);
		return o;
	}

}
