package com.Estacionamiento.Estacionamiento.servicio;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.Estacionamiento.Estacionamiento.testdatabuilder.RegistroTicketTestDataBuilder;

import co.com.estacionamiento.dominio.servicios.ActualizaEstadoTicket;
import co.com.estacionamiento.dominio.servicios.RegistrarEntradaVehiculo;
import co.com.estacionamiento.dominio.constante.ticketConstante;
import co.com.estacionamiento.dominio.excepciones.ExcepcionPlacaEmpiezaConA;
import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.dominio.repositorio.ticketRepositorio;

public class ServicioActualizarTikectTest {
	
	private ticketRepositorio TicketRepositorio;	
   private  RegistroTicketTestDataBuilder ticketTestDataBuilder = new RegistroTicketTestDataBuilder();
	
	@Before
	public void prepararDatos() {
		// arrange
		this.TicketRepositorio = mock(ticketRepositorio.class);
	}
	


}
