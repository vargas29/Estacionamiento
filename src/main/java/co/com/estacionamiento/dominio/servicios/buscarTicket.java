package co.com.estacionamiento.dominio.servicios;


import co.com.estacionamiento.dominio.repositorio.ticketRepositorio;

import java.util.List;

import co.com.estacionamiento.dominio.modelo.Ticket;

public class buscarTicket {
	
	
private ticketRepositorio repositorioTicket;
	
	public buscarTicket(ticketRepositorio repositorioTicket){
        this.repositorioTicket = repositorioTicket;
    }
	
	public List<Ticket> listarTickets(){
        return this.repositorioTicket.listarTickets();
    }
	public Ticket buscarTicket( String placaVehiculo){
		Ticket ticket = this.repositorioTicket.buscarTicket(placaVehiculo);
        return this.repositorioTicket.buscarTicket(placaVehiculo);
    }
}
