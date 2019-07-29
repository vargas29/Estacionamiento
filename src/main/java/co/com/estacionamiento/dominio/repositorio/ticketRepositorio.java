package co.com.estacionamiento.dominio.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.estacionamiento.dominio.modelo.Ticket;

@Repository
public interface ticketRepositorio {

	public Ticket registrarTicket(Ticket estacionamiento);
	public Ticket actualizarSalidaTicket(Ticket estacionamiento);
	public List<Ticket> listarTickets();

	public Ticket buscarTicket(String placaVehiculo);
	public int numCuposTipoVehiculo (String tipoVehiculo);
}
