package com.Estacionamiento.Estacionamiento.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.estacionamiento.dominio.modelo.Ticket;
import com.Estacionamiento.Estacionamiento.testdatabuilder.TicketTestDataBuillder;


@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ParkingApplication.class)
@AutoConfigureMockMvc
public class ticketControladorTest {
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;	
	

	@Before
	public void setUp() {
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	
	public void registroTicketTest() throws Exception {
	Ticket ticket = new TicketTestDataBuillder().build();

	mockMvc.perform(post("/api/Tickets")
	.content(new ObjectMapper().writeValueAsString(ticket))
	.contentType(MediaType.APPLICATION_JSON))	
	.andExpect(status().isCreated())
	.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	//.andExpect(jsonPath("$.placa").value(PLACA));
	}

}
