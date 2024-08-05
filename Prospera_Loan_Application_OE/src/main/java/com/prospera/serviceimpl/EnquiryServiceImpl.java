package com.prospera.serviceimpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.prospera.model.Cibil;
import com.prospera.model.Enquiry;
import com.prospera.repository.EnquiryRepository;
import com.prospera.servicei.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI
{
	@Autowired
	EnquiryRepository er;
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public ResponseEntity<String> calculateCibil(int enquiryID)
	{
		Enquiry en=er.findById(enquiryID).get();
		Random random=new Random();
		int max=900,min=300;
		int randomnum=random.nextInt(min,max);
		Cibil c=new Cibil();
		c.setCibilscore(randomnum);
		
		if(randomnum>650)
		{
			c.setCibilStatus("Approved");
			en.setLoanStatus("Cibil Approved");
		}
		else
		{
			c.setCibilStatus("Rejected");
			en.setLoanStatus("Cibil Rejected");
		}
		en.setCibil(c);
		er.save(en);
		ResponseEntity<String> response=new ResponseEntity<String>("Your Cibil Score is "+randomnum,HttpStatus.OK);
		 try
		 {
		SimpleMailMessage message=new SimpleMailMessage();
		if(c.getCibilStatus().equals("Approved"))
		{
			message.setTo(en.getEmail());
			message.setSubject("Congratulations " + en.getFirstName());
			message.setText("Your cibil score is approved-" +c.getCibilscore()+"\n"+"Required documents for Further Process are following - \n"+" 1. Adharcard \n"+ "2. PanCard \n"+"3. 2 photo copy \n"+"4. Address Proof \n"+"5. Light bill");
			
		}
		else
		{
			message.setTo(en.getEmail());
			message.setSubject("Sorry " + en.getFirstName());
			message.setText("Your Cibil Score Rejected");
		}
			sender.send(message);    
		
			
		
		 }
		catch(MailException exception)
		{
			System.out.println("email is incorrect");
		}
		return response;
	

}
}
