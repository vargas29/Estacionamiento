package co.com.estacionamiento.infraestructura.repositorio;



import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import co.com.estacionamiento.infraestructura.entidades.ticketEntidad;
@CrossOrigin(origins = "http://localhost:4200")
public interface RepositorioTicketMemoria   extends CrudRepository<ticketEntidad, Integer>{

    @Query("SELECT p FROM ticketEntidad p WHERE p.fechaSalida IS NULL")
    List<ticketEntidad> mostrarTicket();
    
    @Query("SELECT p FROM ticketEntidad p WHERE p.placaVehiculo = :placaVehiculo")
    ticketEntidad buscarTicket(@Param("placaVehiculo") String placaVehiculo);
    
    @Query("SELECT COUNT(p.tipoVehiculo) FROM ticketEntidad p  WHERE p.tipoVehiculo = :tipoVehiculo")
    int numCuposTipoVehiculo(@Param("tipoVehiculo") String tipoVehiculo);
  

}
