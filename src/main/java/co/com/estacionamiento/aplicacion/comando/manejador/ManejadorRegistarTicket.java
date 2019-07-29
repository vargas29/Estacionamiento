package co.com.estacionamiento.aplicacion.comando.manejador;


import org.springframework.stereotype.Service;
import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.dominio.servicios.RegistrarEntradaVehiculo;
import co.com.estacionamiento.dominio.servicios.ActualizaEstadoTicket;;
@Service
public class ManejadorRegistarTicket {
	

	private final RegistrarEntradaVehiculo servicioRegistarTicket;
	private final ActualizaEstadoTicket servicioActualizarTicket;

	public ManejadorRegistarTicket(RegistrarEntradaVehiculo servicioRegistarTicket,ActualizaEstadoTicket servicioActualizarTicket) {
		this.servicioRegistarTicket = servicioRegistarTicket;
		this.servicioActualizarTicket = servicioActualizarTicket;
	}

	public  Ticket crear(Ticket ticket) {
		//Fecha de ingreso cuando se registra el vehiculo
		 // Calendar fechaIngreso = Calendar.getInstance();  
		return this.servicioRegistarTicket.registrar(new Ticket(ticket.getId(),ticket.getTipoVehiculo(),
				ticket.getPlacaVehiculo(),ticket.getFechaIngreso(),ticket.getFechaSalida(),ticket.getCilindraje(),ticket.getTotal()));
		
	}
	public Ticket actualizar (Ticket ticket) {
		System.out.println(ticket);
		return this.servicioActualizarTicket.liquidarSalidar(new Ticket(ticket.getId(),ticket.getTipoVehiculo(),
				ticket.getPlacaVehiculo(),ticket.getFechaIngreso(),ticket.getFechaSalida(),ticket.getCilindraje(),ticket.getTotal()));
	}

}
