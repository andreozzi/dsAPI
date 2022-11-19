package com.devs.dsapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devs.dsapi.entities.Sales;
import com.devs.dsapi.repositories.SalesRespositories;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsServices {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SalesRespositories salesRespositories;

	public void sendSms(Long idSale) {
		
		Sales sales = salesRespositories.findById(idSale).get();
		
		
		String data = sales.getDate().getMonthValue() + "/" + sales.getDate().getYear();
				
		String msg = "Vendedor: "+ sales.getSellerName() + " foi destaque em "+data
				+" com um total de R$ "+ String.format("%.2f", sales.getAmount());

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}