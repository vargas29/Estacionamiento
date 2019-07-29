package co.com.estacionamiento.infraestructura.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.estacionamiento.aplicacion.comando.comandoTicket;
import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.aplicacion.comando.manejador.ManejadorRegistarTicket;
import co.com.estacionamiento.aplicacion.consulta.ManejardorListarVehiculos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/Tickets")
public class ComandocontroladorTicket {
	
    //@Autowired
	private final ManejadorRegistarTicket manejadorRegistarTicket;
    private final ManejardorListarVehiculos manejadorListarVehiculos;
    
	public ComandocontroladorTicket(ManejadorRegistarTicket manejadorRegistarTicket,
			ManejardorListarVehiculos manejadorListarVehiculos) {
		this.manejadorRegistarTicket = manejadorRegistarTicket;
		this.manejadorListarVehiculos =manejadorListarVehiculos;
	}
	
	@PostMapping
	public ResponseEntity<Ticket> crear(@RequestBody Ticket ticket) {
		return new ResponseEntity<>(this.manejadorRegistarTicket.crear(ticket),HttpStatus.CREATED);
	}

	@GetMapping
	public List<Ticket> listarVehiculos() {
		return this.manejadorListarVehiculos.listarTickets();
	}
	
   @GetMapping("/{placaVehiculo}")
	 public ResponseEntity<Ticket> buscarTicket(@PathVariable String placaVehiculo) {
		return new ResponseEntity<>(this.manejadorListarVehiculos.buscarTicket(placaVehiculo.toLowerCase()),HttpStatus.OK);
	 
	 }
   
   @PutMapping("/{placaVehiculo}")
   public ResponseEntity<Ticket> actualizar(@PathVariable String placaVehiculo, @Valid @RequestBody Ticket ticket) {
	   return new ResponseEntity<>(this.manejadorRegistarTicket.actualizar(ticket),HttpStatus.OK);


   }
}
