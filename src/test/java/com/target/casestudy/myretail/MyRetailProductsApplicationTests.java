package com.target.casestudy.myretail;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyRetailProductsApplicationTests {

	private MockMvc mockMvc;
	
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        Assert.assertNotNull(mockMvc);
    }
    
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testReadingResource() throws Exception{
		this.mockMvc.perform(get("/products/13860428").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.id").value(13860428))
        .andExpect(jsonPath("$.name").value("The Big Lebowski [Blu-ray]"))
        .andExpect(jsonPath("$.currentPrice.currencyCode").value("USD"));
	}
	
	@Test
	public void testUpdatePriceResource() throws Exception{
		
		Random rand = new Random();
		final int price = rand.nextInt(99);
		String content = "{  \"id\": 13860428,    \"name\": \"The Big Lebowski [Blu-ray]\",  \"currentPrice\": {    \"value\": "+price+" ,    \"currencyCode\": \"USD\"  }}";
		this.mockMvc.perform(put("/products/13860428")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(content)
				)
        .andExpect(status().isOk());
		
		this.mockMvc.perform(get("/products/13860428").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.id").value(13860428))
        .andExpect(jsonPath("$.name").value("The Big Lebowski [Blu-ray]"))
        .andExpect(jsonPath("$.currentPrice.value").value(price))
        .andExpect(jsonPath("$.currentPrice.currencyCode").value("USD"));
	}

}
