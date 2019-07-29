package com.Estacionamiento.Estacionamiento.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.Estacionamiento.Estacionamiento.testdatabuilder.RegistroTicketTestDataBuilder;

import co.com.estacionamiento.dominio.servicios.RegistrarEntradaVehiculo;
import co.com.estacionamiento.dominio.constante.ticketConstante;
import  co.com.estacionamiento.dominio.excepciones.*;
import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.dominio.repositorio.ticketRepositorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ServicioRegistrarVehiculoTest {
	
	
	
	private ticketRepositorio TicketRepositorio;
	private  RegistroTicketTestDataBuilder ticketTestDataBuilder = new RegistroTicketTestDataBuilder();
	
	@Before
	public void prepararDatos() {
		// arrange
		this.TicketRepositorio = mock(ticketRepositorio.class);
	}
	
	
	@Test
	public void validarExcepcionPlacaEmpiezaConA() {
		
		String fecha = "sun Jul 28 15:27:23 2019";
		SimpleDateFormat formatter5=new SimpleDateFormat("E MMM dd HH:mm:ss yyyy");  
	    Date date5 = null;
		try {
			date5 = formatter5.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//Arrange
		RegistroTicketTestDataBuilder ticketTestDataBuilder = new RegistroTicketTestDataBuilder();
				
		Calendar cal = Calendar.getInstance();
		Ticket ticket=  ticketTestDataBuilder.build();
		RegistrarEntradaVehiculo crearServicio = new RegistrarEntradaVehiculo(TicketRepositorio);
		ticket.setFechaIngreso(date5);
		
		ticket.setPlacaVehiculo("ABC123");
		 //Act
        try {
        	crearServicio.registrar(ticket);
            fail();
        }catch (ExcepcionPlacaEmpiezaConA e){
            // Assert
            assertEquals(ticketConstante.PLACA_INICIAN_LETRA_A, e.getMessage());
        }

	}
	
	@Test
	public void validarExcepcionCupoCarro() {
	    RegistrarEntradaVehiculo servicio = new RegistrarEntradaVehiculo(TicketRepositorio);
		Ticket ticket=  ticketTestDataBuilder.build();
		
		ticket.setTipoVehiculo(ticketConstante.TIPO_VEHICULO_CARRO);
		when(TicketRepositorio.numCuposTipoVehiculo(ticketConstante.TIPO_VEHICULO_CARRO)).thenReturn(ticketConstante.NUMERO_CARROS);

       	try {
	    	servicio.registrar(ticket);
            //fail();
        }catch (ExcepcionCuposTipoVehiculo e){
            // Assert
            assertEquals(ticketConstante.NO_EXISTE_CUPOS_DISPONIBLES_TIPO_VEHICULO, e.getMessage());
        }
	}
	
	

	
	@Test
	public void ValidarDisponibilidadCupoMoto() {
	    RegistrarEntradaVehiculo servicio = new RegistrarEntradaVehiculo(TicketRepositorio);
		Ticket ticket=  ticketTestDataBuilder.build();
		
	
		when(TicketRepositorio.numCuposTipoVehiculo(ticketConstante.TIPO_VEHICULO_MOTO)).thenReturn(ticketConstante.NUMERO_MOTOS);

       	try {
	    	servicio.registrar(ticket);
            
        }catch (ExcepcionExistenciaEstacionamiento e){
            // Assert
            assertEquals(ticketConstante.NO_EXISTE_CUPOS, e.getMessage());
        }
	}
	
	@Test
	public void validarCupoVehiculo() {
	    RegistrarEntradaVehiculo servicio = new RegistrarEntradaVehiculo(TicketRepositorio);
		Ticket ticket=  ticketTestDataBuilder.build();
		ticket.setPlacaVehiculo("CBP123");
	
		when(TicketRepositorio.buscarTicket(ticketConstante.NUMERO_PLACA)).thenReturn(ticket);
		System.out.println(ticketConstante.NUMERO_PLACA);
       	try {
	    	servicio.registrar(ticket);
          
        }catch (ExcepcionValidaCupoVehiculo e){
            // Assert
            assertEquals(ticketConstante.LA_PLACA_SE_ENCUENTRA_REGISTRADA, e.getMessage());
        }
	}
}
