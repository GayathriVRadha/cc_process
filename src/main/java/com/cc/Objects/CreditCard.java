package com.cc.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@Table(name = "CREDITCARD")
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int cardId;

	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	@Column(name = "creditCardNumber")
	private String creditCardNumber;
	@Column(name = "customerName")
	private String customerName;
	@Column(name = "creditCardlimit")
	private long creditCardlimit;
	@Column(name = "initBalance")
	private long initBalance;

	
	public CreditCard() {
		
	}
	public CreditCard(String customerName, String creditCardNumber, Long limit,Long initBalance) {
		this.creditCardNumber=creditCardNumber;
		this.customerName=customerName;
		this.creditCardlimit=creditCardlimit;
		this.initBalance=initBalance;
	}

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

	public long getInitBalance() {
		return initBalance;
	}

	public void setInitBalance(long initBalance) {
		this.initBalance = initBalance;
	}
	public long getCreditCardlimit() {
		return creditCardlimit;
	}
	public void setCreditCardlimit(long creditCardlimit) {
		this.creditCardlimit = creditCardlimit;
	}

}
