package com.cc.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor  
@AllArgsConstructor  
@ToString
public class CreditCardVO {
 
	private String creditCardNumber;
	private String customerName;
	private long creditCardlimit;
	private long initBalance;
	public long getInitBalance() {
		return initBalance;
	}

	public void setInitBalance(long initBalance) {
		this.initBalance = initBalance;
	}

	@JsonIgnore
	private int cardId;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCreditCardlimit() {
		return creditCardlimit;
	}

	public void setCreditCardlimit(long creditCardlimit) {
		this.creditCardlimit = creditCardlimit;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	
}
