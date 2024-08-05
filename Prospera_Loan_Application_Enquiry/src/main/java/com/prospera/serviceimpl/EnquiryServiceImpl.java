package com.prospera.serviceimpl;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.prospera.exceptionhandler.EnquiryIdNotFoundException;
import com.prospera.exceptionhandler.PanCardAlreadySubmittedException;
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
	public ResponseEntity<Enquiry> addEnquiry(Enquiry e)
	{
		e.setLoanStatus("Pending");
		e.setEnquiryStatus("Initaited");
		e.setTimeStamp(LocalDateTime.now());
		Optional<Enquiry> o = er.findByPancardNo(e.getPancardNo());
		if(o.isPresent())
		{
			throw new PanCardAlreadySubmittedException("Pan card has already been used for enquiry");
		}
		
		er.save(e);
		ResponseEntity<Enquiry> response = new ResponseEntity<Enquiry>(e,HttpStatus.OK);
		try
		{
		  SimpleMailMessage message=new SimpleMailMessage();
		  message.setTo(e.getEmail());
		  message.setSubject("Welcome "+ e.getFirstName());
		  message.setText("Hello "+ e.getFirstName()+",\nWe are pleased to know about your interest in Prospera Loans.");
		  sender.send(message);
		}
		catch(MailException exception)
		{
			System.out.println("email is incorrect");
		}
		return response;
	}
	
	@Override
	public ResponseEntity<Enquiry> getById(int enquiryID)
	{
        Optional<Enquiry> o = er.findById(enquiryID);
		if(o.isPresent())
		{
			ResponseEntity<Enquiry> response = new ResponseEntity<>(o.get(),HttpStatus.OK);
			return response;
		}
		else
		{
			throw new EnquiryIdNotFoundException("Id not found");
		}
    }


	
	@Override
	public Optional<Enquiry> getEnquiryById(int enquiryID)
	{
		Optional<Enquiry> o = er.findById(enquiryID);
		return o;
	}
	
	@Override
	public List<Enquiry> getEnquiryByLoanStatus(String loanStatus)
	{
		List<Enquiry> l = er.findAllByLoanStatus(loanStatus);
		return l;
	}
	
	@Override
	public List<Enquiry> getEnquiryByEnquiryStatus(String enquiryStatus)
	{
		List<Enquiry> l = er.findAllByEnquiryStatus(enquiryStatus);
		return l;
	}
	
	@Override
	public List<Enquiry> getallenquiry()
	{
		List<Enquiry> l = er.findAll();
		
		return l;
	}
	
	@Override
	public ResponseEntity<Enquiry> updateEnquiry(int enquiryID, Enquiry e)
	{

		er.save(e);
		ResponseEntity<Enquiry> response = new ResponseEntity<Enquiry>(HttpStatus.OK);
		return response;
	   }


	@Override
	public ResponseEntity<String> deleteById(int enquiryID)
	{
		Optional<Enquiry> o = er.findById(enquiryID);
		if(o.isPresent())
		{
			er.deleteById(enquiryID);
			ResponseEntity<String> response = new ResponseEntity<String>("Enquiry deleted succesffuly", HttpStatus.OK);
			return response;
		}
		else
		{
			throw new EnquiryIdNotFoundException("Id not found");
		}	
	}

	@Override
	public ResponseEntity<String> forwardToOE(int enquiryID)
	{
		Optional<Enquiry> o = er.findById(enquiryID);
		if(o.isPresent())
		{
			Enquiry e = o.get();
			e.setEnquiryStatus("Forwarded to OE");
			er.save(e);
			return new ResponseEntity<String>("Enquiry has been successfully forwared to OE",HttpStatus.OK);
		}
		else
		{
			throw new EnquiryIdNotFoundException("Id not found");
		}
	}

}
