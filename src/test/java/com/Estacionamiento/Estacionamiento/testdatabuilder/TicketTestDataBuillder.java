
package com.Estacionamiento.Estacionamiento.testdatabuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.dominio.servicios.ActualizaEstadoTicket;
import co.com.estacionamiento.dominio.constante.ticketConstante;

public class TicketTestDataBuillder {
	
	private int id;
	private String tipoVehiculo;
	private String placaVehiculo;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String cilindraje;
	private double total;
	

	@SuppressWarnings("deprecation")
	public TicketTestDataBuillder() {
		this.id=1;
		this.tipoVehiculo="Moto";
		this.placaVehiculo="QWE123";
		this.fechaIngreso=new Date("sun Jul 28 15:27:23 2019");
		this.fechaSalida=null;
		this.cilindraje="560";
		this.total=0.0;
	}
	
	public TicketTestDataBuillder conId(int id) {
		this.id=id;
		return this;
		
	}
	
	public TicketTestDataBuillder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo=tipoVehiculo;
		return this;
		
	}
	
	public TicketTestDataBuillder conPlacaVehiculo(String placaVehiculo) {
		
		this.placaVehiculo=placaVehiculo;
		return this;
		
	}
	
	public TicketTestDataBuillder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso=fechaIngreso;
		return this;
		
	}
	
	public TicketTestDataBuillder conFechaSalida(Date fechaSalida) {
		this.fechaSalida=fechaSalida;
		return this;
		
	}
	
	public TicketTestDataBuillder conCilindraje(String cilindraje) {
		this.cilindraje=cilindraje;
		return this;
		
	}
	
	public TicketTestDataBuillder conTotal(double total) {
		this.total=total;
		return this;
		
	}
	
	public Ticket build() {
		return new Ticket(id,tipoVehiculo,placaVehiculo,fechaIngreso,fechaSalida,cilindraje,total);
	}

}

