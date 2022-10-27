package com.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cc.Objects.CreditCard;
import com.cc.controller.CreditCardController;
import com.cc.service.CreditCardService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CreditCardController.class)
public class CreditCardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreditCardService creditCardService;
	

	String exampleJson = "{\"customerName\":\"Fiona\",\"creditCardNumber\":\"4656465655\",\"limit\":\"1000\",\"initBalance\":\"0\"}";
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {

		List<CreditCard> ccDetail = new ArrayList();
		CreditCard cc=new CreditCard("Raji", "124324343565", 1000L,0L);
		ccDetail.add(cc);

		Mockito.when(creditCardService.getAllCreditCardDetails()).thenReturn(ccDetail);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/cc/getAllCCDetails").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"customerName\":\"Fiona\",\"creditCardNumber\":\"4656465655\",\"limit\":\"1000\",\"initBalance\":\"0\"}";


		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	
	@Test
	public void createStudentCourse() throws Exception {
		CreditCard cCard = new CreditCard("Raji", "124324343565", 1000L,0L);

		Mockito.when(creditCardService.saveCC(
						Mockito.any(CreditCard.class))).thenReturn(cCard);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/cc/addCCDetails")
				.accept(MediaType.APPLICATION_JSON).content(exampleJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

//		mvc.perform(get("/api/employees")
//			      .contentType(MediaType.APPLICATION_JSON))
//			      .andExpect(status().isOk())
//			      .andExpect(jsonPath("$", hasSize(1)))
//			      .andExpect(jsonPath("$[0].name", is(alex.getName())));

	}
}
