package com.prospera.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.prospera.model.Enquiry;
import com.prospera.repository.EnquiryRepository;
import com.prospera.servicei.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI{

	@Autowired
	EnquiryRepository er;
	
	@Autowired 
	private JavaMailSender sender;
	
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
		try
		{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(e.getEmail());
		message.setSubject("welcome"+ " " + e.getFirstName());
		message.setText("welcome"+ " " + e.getFirstName()+" "+"to Prospera application");
		sender.send(message);
		}
		catch(MailException exception)
		{
			System.out.println("email is incorrect");
		}
		return response;
	}

	@Override

	public ResponseEntity<Enquiry> getallenquiry(Enquiry e) {
		
		er.findAll();
		ResponseEntity<Enquiry> response = new ResponseEntity<Enquiry>(e,HttpStatus.OK);
    return response;
}
@Override
	public ResponseEntity<Enquiry> getById(int enquiryID) 
	{
		er.findById(enquiryID);
		ResponseEntity<Enquiry> response = new ResponseEntity<Enquiry>(HttpStatus.OK);

		return response;
	}




	


}
