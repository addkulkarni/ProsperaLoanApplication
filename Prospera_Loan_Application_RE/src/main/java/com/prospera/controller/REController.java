package com.prospera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospera.model.Enquiry;
import com.prospera.servicei.EnquiryServiceI;


@RestController

public class REController
{
	
	@Autowired
	EnquiryServiceI esi;
	
	@GetMapping("/")
	public String calculateCibil()
	{
		 return "RE";
	}
	
	
}
