package co.com.estacionamiento.infraestructura.configurador;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import co.com.estacionamiento.aplicacion.comando.manejador.ManejadorRegistarTicket;
import co.com.estacionamiento.dominio.repositorio.ticketRepositorio;
import co.com.estacionamiento.aplicacion.consulta.ManejardorListarVehiculos;
import co.com.estacionamiento.dominio.servicios.*;
import org.springframework.context.annotation.Bean;

@Configuration
public class ConfiguracionBean {
	/*
	@Bean
    public ManejadorRegistarTicket entradaVehiculoHandler(RegistrarEntradaVehiculo registrarTicketServicio) {
        return new ManejadorRegistarTicket(registrarTicketServicio);
    }
	*/
	
	//@Primary
	@Bean
    public RegistrarEntradaVehiculo registrarTicketServicio(ticketRepositorio repositorioTicket){
        return new RegistrarEntradaVehiculo(repositorioTicket);
    }
	
	@Bean
    public ActualizaEstadoTicket actualizarTicketServicio(ticketRepositorio repositorioTicket){
        return new ActualizaEstadoTicket(repositorioTicket);
    }
	
    @Bean
    public ManejardorListarVehiculos listaTicketHandler(buscarTicket buscarListaServicio) {
        return new ManejardorListarVehiculos(buscarListaServicio);
    }

    
    @Bean
    public buscarTicket listaTicketServicio(ticketRepositorio repositorioTicket) {
        return new buscarTicket(repositorioTicket);
    }
}
