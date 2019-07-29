package co.com.estacionamiento.infraestructura.mapeador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.infraestructura.entidades.ticketEntidad;

@Component	
public class MapeadorTicket {
	
	
	public Ticket convertirADominio(ticketEntidad ticketEntidad) {
		Ticket ticket;

		if (ticketEntidad == null) {
			ticket = null;
		} else {
			ticket = new Ticket(ticketEntidad.getId(),ticketEntidad.getTipoVehiculo(),ticketEntidad.getPlacaVehiculo(),
					ticketEntidad.getFechaIngreso(),ticketEntidad.getFechaSalida(),ticketEntidad.getCilindraje(),ticketEntidad.getTotal());
		}

		return ticket;
	}

	public ticketEntidad convertirAEntidad(Ticket ticket) {
		ticketEntidad entidadTicket;

		if (ticket == null) {
			entidadTicket = null;
		} else {
			entidadTicket = new ticketEntidad(ticket.getId(),ticket.getTipoVehiculo(),ticket.getPlacaVehiculo().toLowerCase(),
					ticket.getFechaIngreso(),ticket.getFechaSalida(),ticket.getCilindraje(),ticket.getTotal());
		}
		return entidadTicket;

	}
	
	public List<Ticket> listaConvertirADominio(List<ticketEntidad> listaTicketEntidad) {
		final List<Ticket> listarTicket = new ArrayList<>();;

		listaTicketEntidad.forEach(ticketEntidad -> listarTicket.add(new Ticket(ticketEntidad.getId(),
				ticketEntidad.getTipoVehiculo(),ticketEntidad.getPlacaVehiculo(),ticketEntidad.getFechaIngreso(),
				ticketEntidad.getFechaSalida(),ticketEntidad.getCilindraje(),ticketEntidad.getTotal())));

		return listarTicket;
	}
	
}	
