package com.cc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cc.Objects.CreditCard;
import com.cc.Objects.CreditCardVO;
import com.cc.helper.CreditCardValidator;
import com.cc.service.CreditCardService;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CreditCardController {
	
	@Autowired
	private  CreditCardService cardService ;
	public CreditCardController() {
		
		
	}
	
	public CreditCardController(CreditCardService cardService) {
		this.cardService=cardService;
	}
	 

		// TODO Auto-generated constructor stub
		@PostMapping(value="/addCCDetails",consumes = MediaType.APPLICATION_JSON_VALUE,
		        produces = MediaType.APPLICATION_JSON_VALUE)
		private ResponseEntity<Object> addCreditCardDetails(@RequestBody CreditCardVO ccVO) {
			System.out.println("Entering add details");
			CreditCard card = new CreditCard();
			ObjectMapper mapper=new ObjectMapper();
            if(CreditCardValidator.validateCreditCardDetails(ccVO)) {
            	card= mapper.convertValue(ccVO, CreditCard.class);
            	card.setInitBalance(0L);
            	cardService.saveCC(card);
            	return new ResponseEntity<>(card,HttpStatus.CREATED);
            }
            else {
            	return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Invalid Card Details");
            }
			

			
		}
		
		@GetMapping(value="/getAllCCDetails",headers = "Accept=application/json")
		private ResponseEntity<List<CreditCardVO>> getCreditCardDetails() {
			List<CreditCard> cards = new ArrayList();
			List<CreditCardVO> voCards = new ArrayList();
			cards=cardService.getAllCreditCardDetails();
			ObjectMapper mapper=new ObjectMapper();
			for(CreditCard c: cards) {
				voCards.add(mapper.convertValue(c, CreditCardVO.class));
			}
           return new ResponseEntity<List<CreditCardVO>>(voCards,HttpStatus.OK);

			//res.getbody
		}

		

}
