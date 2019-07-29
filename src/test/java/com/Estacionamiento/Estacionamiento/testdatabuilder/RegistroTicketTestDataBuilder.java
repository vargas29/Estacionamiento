package com.Estacionamiento.Estacionamiento.testdatabuilder;

import java.util.Date;
import lombok.Data;

import co.com.estacionamiento.dominio.modelo.Ticket;
@Data
public class RegistroTicketTestDataBuilder {

	
	private int id;
	private String tipoVehiculo;
	private String placaVehiculo;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String cilindraje;
	private double total;
	
	public RegistroTicketTestDataBuilder() {
		this.id=1;
		this.tipoVehiculo="Avion";
		this.placaVehiculo="PPP123";
		this.fechaIngreso=new Date();
		this.fechaSalida=null;
		this.cilindraje="500CC";
		this.total=0.0;
	}
	
	public Ticket build(){
    	return new Ticket(id, tipoVehiculo, placaVehiculo, fechaIngreso, fechaSalida, cilindraje, total);
    }
}
