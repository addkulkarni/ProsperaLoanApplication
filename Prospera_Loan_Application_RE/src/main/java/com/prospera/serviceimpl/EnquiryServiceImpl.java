package com.prospera.serviceimpl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prospera.model.Customer;
import com.prospera.model.Enquiry;
import com.prospera.repository.CustomerRepository;
import com.prospera.repository.EnquiryRepository;
import com.prospera.servicei.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI
{
     @Autowired
     EnquiryRepository er;
     
     @Autowired
     CustomerRepository cr;

	@Override
	public ResponseEntity<String> addCustomer(Customer c,int enquiryID) 
	{
		Enquiry e=er.findById(enquiryID).get();
//		c.setEnq(e);
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random=new Random();
		String username="";
		for(int i=1;i<=6;i++)
		{
			int num=random.nextInt();
			username=username+str.charAt(num);
		}
		String password="";
		for(int i=1;i<=6;i++)
		{
			int num=random.nextInt();
			password=password+str.charAt(num);
		}
		c.setFirstName(e.getFirstName());
		c.setLastName(e.getLastName());
		c.setGender(e.getGender());
		c.setAdharcardNo(e.getAdharcardNo());
		c.setAge(e.getAge());
		c.setMobileNo(e.getMobileNo());
		c.setPancardNo(e.getPancardNo());
		c.setUsername(username);
		c.setPassword(password);
		c.setDob(new Date());
		cr.save(c);
		ResponseEntity<String> response = new ResponseEntity<String>("data saves successfully",HttpStatus.OK);
		return response;
	}

	
//	@Override
//	public void saveData(Customer cus) 
//	{
//		er.save(cus);
//	}


     
//	@Override
//	public ResponseEntity<String> addCustomer(Customer c,String email) 
//	{ 
//		Enquiry e=er.findByEmail(email);
//		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//		Random random=new Random();
//		String username="";
//		for(int i=1;i<=6;i++)
//		{
//			int num=random.nextInt();
//			username=username+str.charAt(num);
//		}
//		String password="";
//		for(int i=1;i<=6;i++)
//		{
//			int num=random.nextInt();
//			password=password+str.charAt(num);
//		}
//		c.setFirstName(e.getFirstName());
//		c.setLastName(e.getLastName());
//		c.setGender(e.getGender());
//		c.setAdharcardNo(e.getAdharcardNo());
//		c.setAge(e.getAge());
//		c.setMobileNo(e.getMobileNo());
//		c.setPancardNo(e.getPancardNo());
//		c.setUsername(username);
//		c.setPassword(password);
//		c.setDob(new Date());
//		er.save(c);
//		ResponseEntity<String> response = new ResponseEntity<String>("Customer data added",HttpStatus.OK);
//		return response;
//	}
//	
}
