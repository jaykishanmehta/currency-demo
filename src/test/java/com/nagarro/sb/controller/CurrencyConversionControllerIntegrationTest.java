package com.nagarro.sb.controller;

import static org.hamcrest.Matchers.anything;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.nagarro.sb.service.util.CacheManager;
import com.nagarro.sb.util.RateConvertor;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class CurrencyConversionControllerIntegrationTest {

	@MockBean
	private CacheManager cacheManager;

	@MockBean
	private RateConvertor convertor;

	@Autowired
	private MockMvc mockMvc;

	
	@Test
	public void whenPostRequestToCurrencyConversionController_thenCorrectResponse() throws Exception {
		
		String payload = "{\r\n"
				+ "    \"from\": \"usd\",\r\n"
				+ "    \"to\": \"inr\",\r\n"
				+ "    \"amount\": 10\r\n"
				+ "}";
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/convert-currency").content(payload).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.convertedToAmount", anything()));
	}
	
	@Test
	public void whenGetCurrencyList_thenValidateCorrectResponse() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/available-currencies"))
			.andExpect(MockMvcResultMatchers.status().isOk());
				
	}
	
	@Test
	public void whenGetAvailableCurrencyConversionList_thenValidateCorrectResponse() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/available-conversions"))
			.andExpect(MockMvcResultMatchers.status().isOk());
				
	}

}
