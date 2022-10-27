package com.cc.helper;

import org.springframework.util.StringUtils;

import com.cc.Objects.CreditCardVO;

public class CreditCardValidator {

	public CreditCardValidator() {
		// TODO Auto-generated constructor stub
	}
	
	public static  boolean validateCreditCardDetails(CreditCardVO ccVO) {
		if(null!=ccVO && !StringUtils.isEmpty(ccVO.getCreditCardNumber()) && checkLuhn(ccVO.getCreditCardNumber() )) 
		{
			long CCNumber = Long.parseLong(ccVO.getCreditCardNumber());
//			if(getSize(CCNumber) >= 13 &&
//		               getSize(CCNumber) <= 19) {
//				return true;
//			}
//		
			return true;
		}
		// TODO Auto-generated method stub
		return false;
		
	}
	
	public static int getSize(long d)
    {
        String num = d + "";
        return num.length();
    }
	/**
	 * Step 1. Double every second digit from right to left. If doubling of a digit results in a 
two-digit number, add up the two digits to get a single-digit number (like for 12:1+2, 18=1+8).
Step 2. Now add all single-digit numbers from Step 1. 
4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37
Step 3. Add all digits in the odd places from right to left in the card number. 
6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38
Step 4. Sum the results from Step 2 and Step 3. 37 + 38 = 75
Step 5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise, it is invalid. 
	 * @param cardNo
	 * @return
	 */
	private static boolean checkLuhn(String cardNo)
	{
	    int nDigits = cardNo.length();
	 
	    int nSum = 0;
	    boolean isSecond = false;
	    for (int i = nDigits - 1; i >= 0; i--)
	    {
	 
	        int d = cardNo.charAt(i) - '0';
	 
	        if (isSecond == true)
	            d = d * 2;
	 
	        // We add two digits to handle
	        // cases that make two digits
	        // after doubling
	        nSum += d / 10;
	        nSum += d % 10;
	 
	        isSecond = !isSecond;
	    }
	    return (nSum % 10 == 0);
	}

}
