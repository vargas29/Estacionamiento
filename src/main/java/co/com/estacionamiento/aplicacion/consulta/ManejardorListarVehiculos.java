package co.com.estacionamiento.aplicacion.consulta;

import java.util.List;

import co.com.estacionamiento.dominio.modelo.Ticket; 
import co.com.estacionamiento.dominio.servicios.buscarTicket;

public class ManejardorListarVehiculos {

	private final buscarTicket buscarTicketServicio;

	public ManejardorListarVehiculos(buscarTicket buscarTicketServicio){
    this.buscarTicketServicio = buscarTicketServicio;
	}

	public List<Ticket> listarTickets(){
    return this.buscarTicketServicio.listarTickets();
	}
	
	public Ticket buscarTicket(String placaVehiculo){
	    return this.buscarTicketServicio.buscarTicket(placaVehiculo);
	}
	

}
