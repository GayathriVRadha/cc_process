package com.cc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cc.Objects.CreditCard;
import com.cc.repository.CreditCardRepository;


@Service
@Component
public class CreditCardService {
	
	@Autowired
	 private CreditCardRepository repository ;


	    public CreditCard saveCC(CreditCard creditCard){
	        return repository.save(creditCard);
	    }


	    public List<CreditCard> getAllCreditCardDetails() {
	        return repository.findAll();
	                
	    }

}
