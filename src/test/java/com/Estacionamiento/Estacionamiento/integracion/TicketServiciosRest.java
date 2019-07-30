package com.Estacionamiento.Estacionamiento.integracion;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.estacionamiento.EstacionamientoApplication;
import co.com.estacionamiento.dominio.constante.ticketConstante;
import co.com.estacionamiento.dominio.modelo.Ticket; 

import com.Estacionamiento.Estacionamiento.testdatabuilder.TicketTestDataBuillder;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoApplication.class)
@AutoConfigureWebMvc
public class TicketServiciosRest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	private  TicketTestDataBuillder data = new TicketTestDataBuillder();
	 
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void registarTicketAPI() throws Exception
	{
		Ticket ticketData = data.build();
	     mvc.perform( MockMvcRequestBuilders
	      .post("/api/Tickets/")
	      .content(new ObjectMapper().writeValueAsString(ticketData))
	    		  .contentType(MediaType.APPLICATION_JSON))	
	    		  .andExpect(status().isCreated())
	    		  .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	    	      .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	  }

	
	
	@Test
	public void listTicketAPI() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/api/Tickets/")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	      
	}
	
	@Test
	public void buscarTicketAPI() throws Exception
	{
		mvc.perform( MockMvcRequestBuilders
				  .get("/api/Tickets/{placaVehiculo}", 1)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk());
	      
	}
	
	@Test
	public void actualizarTicketAPI() throws Exception
	{
		Ticket ticketData = data.build();
		 mvc.perform( MockMvcRequestBuilders
			      .put("/api/Tickets/{placaVehiculo}",1)
			      .content(new ObjectMapper().writeValueAsString(ticketData))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	      
	}
	@Test
	public void actualizarTicketAPITest() throws Exception
	{
		Date fechaIngreso=new Date();
		Ticket ticketData = data.build();
		ticketData.setFechaIngreso(fechaIngreso);
		 mvc.perform( MockMvcRequestBuilders
			      .put("/api/Tickets/{placaVehiculo}",1)
			      .content(new ObjectMapper().writeValueAsString(ticketData))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	      

	}
}

