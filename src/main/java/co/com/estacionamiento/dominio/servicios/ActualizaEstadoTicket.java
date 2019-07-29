package co.com.estacionamiento.dominio.servicios;

import java.util.Calendar;
import java.util.Date;

import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.dominio.constante.ticketConstante;
import co.com.estacionamiento.dominio.repositorio.ticketRepositorio;

public class ActualizaEstadoTicket {


	private ticketRepositorio repositorioTicket;
	
	public ActualizaEstadoTicket(ticketRepositorio repositorioTicket) {
		this.repositorioTicket = repositorioTicket;
	}

	
	public Ticket liquidarSalidar(Ticket ticket) {
		
		ticket.setFechaSalida(fechaSalidad());
		ticket.setTotal(CalcularTotal(ticket));
		
		
		return this.repositorioTicket.actualizarSalidaTicket(ticket);
	}
	
	public Date fechaSalidad() {
		Calendar calendar = Calendar.getInstance(); 
		return calendar.getTime();
	}
	
	public Double horasTotal(int horas ,int valorDia,int valorHora) {
		 Double costo;
		if(horas >= 24) {
			costo =(double) (( (horas -24) * valorHora ) + valorDia );
		}else {
			costo =(double) (horas *valorHora) ;
		}
		return costo; 
	}

	public Double totalCarro(int numHoras) {
		return horasTotal(numHoras,ticketConstante.VALOR_DIA_CARRO,ticketConstante.VALOR_HORA_CARRO);
	}
	
	
	public Double totalMoto(int  numHoras,String cilindraje) {
		Double costoHoras =  horasTotal(numHoras,ticketConstante.VALOR_DIA_MOTO,ticketConstante.VALOR_HORA_MOTO);
		
		if(Integer.parseInt(cilindraje) > 500)
			costoHoras= costoHoras+ticketConstante.VALOR_CC_MAYOR_500;
		return costoHoras;
	}
	public Double CalcularTotal(Ticket ticket) {
		int  numeroHoras=numeroHoras(ticket.getFechaIngreso(),ticket.getFechaSalida());
		Double  valorHoras;
	
		if(ticket.getTipoVehiculo().equals(ticketConstante.TIPO_VEHICULO_MOTO)) {
			valorHoras =totalMoto(numeroHoras,ticket.getCilindraje());
		}else {
			valorHoras =totalCarro(numeroHoras);
		}
		
		return valorHoras;
				
		
	}
	
	public int numeroHoras(Date fechaIngreso,Date fechaSalida) {
		return (int) (Math.floor((int)((fechaIngreso.getTime() - fechaSalida.getTime())/1000)/3600));
	}
	
}
