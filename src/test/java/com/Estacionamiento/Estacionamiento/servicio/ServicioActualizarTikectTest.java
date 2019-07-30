package com.Estacionamiento.Estacionamiento.servicio;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import org.junit.Before;
import org.junit.Test;

import com.Estacionamiento.Estacionamiento.BasePrueba;
import com.Estacionamiento.Estacionamiento.testdatabuilder.RegistroTicketTestDataBuilder;
import com.Estacionamiento.Estacionamiento.testdatabuilder.TicketTestDataBuillder;

import co.com.estacionamiento.dominio.servicios.ActualizaEstadoTicket;
import co.com.estacionamiento.dominio.constante.ticketConstante;
import co.com.estacionamiento.dominio.excepciones.ExcepcionCilindraje;
import co.com.estacionamiento.dominio.excepciones.ExcepcionTotalVacio;



import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.dominio.repositorio.ticketRepositorio;

public class ServicioActualizarTikectTest {
	
	private ticketRepositorio TicketRepositorio;	
   private  RegistroTicketTestDataBuilder ticketTestDataBuilder = new RegistroTicketTestDataBuilder();
   private  ActualizaEstadoTicket servicio = new ActualizaEstadoTicket(TicketRepositorio);
	@Before
	public void prepararDatos() {
		// arrange
		this.TicketRepositorio = mock(ticketRepositorio.class);
		this.servicio =  mock(ActualizaEstadoTicket.class);
	}
	
		
		/*
		 * 		String fechaIngresoString = "sun Jul 28 15:27:23 2019";
			SimpleDateFormat fechaIngresoFormat=new SimpleDateFormat("E MMM dd HH:mm:ss yyyy");  
			Date fechaIngreso = fechaIngresoFormat.parse(fechaIngresoString);
			ticket.setFechaIngreso(fechaIngreso);
		 */
	@Test
	public void  validarFechaSalida() {
		
			Ticket ticket=  ticketTestDataBuilder.build();
			
			ticket.setTipoVehiculo(ticketConstante.TIPO_VEHICULO_MOTO);
			ticket.setFechaSalida(null);
			System.out.println(ticket);
			when(servicio.fechaSalidad()).thenReturn(null);
			
	       	try {
		    	servicio.liquidarSalidar(ticket);
	           
	        }catch (ExcepcionTotalVacio e){
	            // Assert
	            assertEquals(ticketConstante.TOTAL_SALIDA_VACIA, e.getMessage());
	        }
		
		
	}
	
	
	@Test
	public void  validarTotal() {
		
			Ticket ticket=  ticketTestDataBuilder.build();

			ticket.setTipoVehiculo(ticketConstante.TIPO_VEHICULO_MOTO);
			ticket.setCilindraje("500");
			ticket.setTotal(0);
		
			when(servicio.CalcularTotal(ticket)).thenReturn(null);
			
	       	try {
		    	servicio.liquidarSalidar(ticket);
	         
	        }catch (ExcepcionTotalVacio e){
	        	  assertEquals(ticketConstante.TOTAL_SALIDA_VACIA, e.getMessage());
	       
	        }
	}

	
}

