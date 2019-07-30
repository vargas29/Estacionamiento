package co.com.estacionamiento.dominio.servicios;
 
import  co.com.estacionamiento.dominio.modelo.Ticket;
import  co.com.estacionamiento.dominio.constante.ticketConstante;
import  co.com.estacionamiento.dominio.excepciones.*;
import  co.com.estacionamiento.dominio.repositorio.ticketRepositorio;


import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

//@Component
public class RegistrarEntradaVehiculo {
	

	private ticketRepositorio repositorioTicket;
	
	public RegistrarEntradaVehiculo(ticketRepositorio repositorioTicket) {
		this.repositorioTicket = repositorioTicket;
	}

	
	public Ticket registrar(Ticket ticket) {
		ticket.setFechaIngreso(fechaIngreso());
		ValidarDisponibilidadCupo();
	    ValidaCupoVehiculoExiste(ticket.getPlacaVehiculo());
		ValidarCuposTipoVehiculo(ticket.getTipoVehiculo());
		ValidarPlacaconLetraA(ticket.getPlacaVehiculo(),ticket.getFechaIngreso());
		return this.repositorioTicket.registrarTicket(ticket);
	}
	
	private Date fechaIngreso(){
		Date fechaIngreso = new Date();
		return fechaIngreso;
		
	} 
	
	private void ValidarPlacaconLetraA(final String placa,final Date fechaIngreso) {
		
		int Dia =fechaIngreso.getDay();

		if(placa.charAt(0)  == 'A' && ( Dia != 0 || Dia != 1 )) 
			throw new ExcepcionPlacaEmpiezaConA(ticketConstante.PLACA_INICIAN_LETRA_A);
	}
	
	private void ValidarCuposTipoVehiculo(final String tipoVehiculo) {
		int  numeroCupo =this.repositorioTicket.numCuposTipoVehiculo(tipoVehiculo);
		
		if( tipoVehiculo.equals(ticketConstante.TIPO_VEHICULO_MOTO) && numeroCupo == ticketConstante.NUMERO_MOTOS)
			throw new ExcepcionCuposTipoVehiculo(ticketConstante.NO_EXISTE_CUPOS_DISPONIBLES_TIPO_VEHICULO);
		if(numeroCupo == ticketConstante.NUMERO_CARROS && tipoVehiculo.equals(ticketConstante.TIPO_VEHICULO_CARRO))
			throw new ExcepcionCuposTipoVehiculo(ticketConstante.NO_EXISTE_CUPOS_DISPONIBLES_TIPO_VEHICULO);
		
	}
	
	private int calcularCupos() {
		int  numeroCuposMoto =this.repositorioTicket.numCuposTipoVehiculo(ticketConstante.TIPO_VEHICULO_MOTO);
		int  numeroCuposCarro =this.repositorioTicket.numCuposTipoVehiculo(ticketConstante.TIPO_VEHICULO_CARRO);
		int numeroCupos =0;
		if(numeroCuposMoto == ticketConstante.NUMERO_MOTOS && numeroCuposCarro == ticketConstante.NUMERO_CARROS ) {
		
			numeroCupos =numeroCuposMoto+numeroCuposCarro;
		}
		return numeroCupos;
	}
	
	private void ValidarDisponibilidadCupo() {
		int numeroCupo=calcularCupos();
		

		
			if( ticketConstante.NUMERO_TOTAL_VEHICULOS == numeroCupo ) 
				throw new ExcepcionExistenciaEstacionamiento(ticketConstante.NO_EXISTE_CUPOS);
		}
		
	
	
	private void ValidaCupoVehiculoExiste( String placaVehiculo) {
		System.out.println(placaVehiculo);
		Ticket  ticket =this.repositorioTicket.buscarTicket(placaVehiculo.toLowerCase());
		System.out.println(this.repositorioTicket.listarTickets());
		System.out.println(ticket);
		if( ticket != null ) 
			throw new ExcepcionValidaCupoVehiculo(ticketConstante.LA_PLACA_SE_ENCUENTRA_REGISTRADA);
	}



}
