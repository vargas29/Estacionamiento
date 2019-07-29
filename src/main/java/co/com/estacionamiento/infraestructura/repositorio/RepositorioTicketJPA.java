package co.com.estacionamiento.infraestructura.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.dominio.repositorio.ticketRepositorio;
import co.com.estacionamiento.infraestructura.mapeador.MapeadorTicket;
import co.com.estacionamiento.infraestructura.repositorio.RepositorioTicketMemoria;
import co.com.estacionamiento.infraestructura.entidades.ticketEntidad;

@Repository
public class RepositorioTicketJPA implements ticketRepositorio  {

	@Autowired
	private RepositorioTicketMemoria repositorioTicketMemoria;
	private MapeadorTicket mapeadorTicket;
	
	
	
	public RepositorioTicketJPA(RepositorioTicketMemoria repositorioTicketMemoria, MapeadorTicket mapeadorTicket){
		this.repositorioTicketMemoria = repositorioTicketMemoria;
        this.mapeadorTicket = mapeadorTicket;
    }
	
	
	 @Transactional
	public Ticket registrarTicket(Ticket estacionamiento) {
		 System.out.println(estacionamiento);
		ticketEntidad entidadTicket = repositorioTicketMemoria.save(mapeadorTicket.convertirAEntidad(estacionamiento));
		return mapeadorTicket.convertirADominio(entidadTicket);
	}


	@Override
	public Ticket buscarTicket(String placaVehiculo) {
	
	ticketEntidad entidadTicket = repositorioTicketMemoria.buscarTicket(placaVehiculo);
			return mapeadorTicket.convertirADominio(entidadTicket);
	}

	@Override
	public List<Ticket> listarTickets() {
		List<ticketEntidad> listarTicketEntidad =repositorioTicketMemoria.mostrarTicket();
		return mapeadorTicket.listaConvertirADominio(listarTicketEntidad);
	}


	@Override
	public Ticket actualizarSalidaTicket(Ticket estacionamiento) {
		ticketEntidad entidadTicket = repositorioTicketMemoria.save(mapeadorTicket.convertirAEntidad(estacionamiento));
		return mapeadorTicket.convertirADominio(entidadTicket);
	}


	@Override
	public int numCuposTipoVehiculo(String tipoVehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
