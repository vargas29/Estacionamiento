package co.com.estacionamiento.dominio.servicios;

import java.util.Calendar;
import java.util.Date;

import co.com.estacionamiento.dominio.modelo.Ticket;
import co.com.estacionamiento.dominio.constante.ticketConstante;
import co.com.estacionamiento.dominio.excepciones.ExcepcionTotalVacio;
import co.com.estacionamiento.dominio.repositorio.ticketRepositorio;

public class ActualizaEstadoTicket {


	private ticketRepositorio repositorioTicket;
	
	public ActualizaEstadoTicket(ticketRepositorio repositorioTicket) {
		this.repositorioTicket = repositorioTicket;
	}

	
	public Ticket liquidarSalidar(Ticket ticket) {
		
		ticket.setFechaSalida(fechaSalidad());
		ticket.setTotal(CalcularTotal(ticket));
	
		validarFechaSalida(ticket.getFechaSalida());
		validarTotal(ticket.getTotal());
		return this.repositorioTicket.actualizarSalidaTicket(ticket);
	}
	
	public Date fechaSalidad() {
		Calendar calendar = Calendar.getInstance(); 
		Date fechaSalida =calendar.getTime();
			
		return fechaSalida;
	}
	
	public Double horasTotal(Double horas ,int valorDia,int valorHora) {
		 Double costo;
	
		if(horas >= 24) {
			costo =(double) (( (horas -24) * valorHora ) + valorDia );
		}else {
			costo =(double) (horas *valorHora) ;
		}
		return costo; 
	}

	public Double totalCarro(Double numHoras) {
		return horasTotal(numHoras,ticketConstante.VALOR_DIA_CARRO,ticketConstante.VALOR_HORA_CARRO);
	}
	
	
	public Double totalMoto(Double  numHoras,String cilindraje) {
		Double costoHoras =  horasTotal(numHoras,ticketConstante.VALOR_DIA_MOTO,ticketConstante.VALOR_HORA_MOTO);
		
		if(Integer.parseInt(cilindraje) >= 500)
			costoHoras= costoHoras+ticketConstante.VALOR_CC_MAYOR_500;
		return costoHoras;
	}
	public Double CalcularTotal(Ticket ticket) {
		Double  numeroHoras=numeroHoras(ticket.getFechaIngreso(),ticket.getFechaSalida());
		Double  valorHoras = null;
	
		if(numeroHoras == 0) 
		{
			if(ticket.getTipoVehiculo().equals(ticketConstante.TIPO_VEHICULO_CARRO))
				valorHoras =ticketConstante.VALOR_HORA_CARRO+0.0;
			if(ticket.getTipoVehiculo().equals(ticketConstante.TIPO_VEHICULO_MOTO)) {
				if(Integer.parseInt(ticket.getCilindraje()) >= 500) {
					valorHoras =ticketConstante.VALOR_HORA_MOTO+0.0+ticketConstante.VALOR_CC_MAYOR_500;
					
				}else {
					valorHoras =ticketConstante.VALOR_HORA_MOTO+0.0;
				}
				
			}
			
		}else {
			if(ticket.getTipoVehiculo().equals(ticketConstante.TIPO_VEHICULO_MOTO)) {
				valorHoras =totalMoto(numeroHoras,ticket.getCilindraje());
			}else {
				valorHoras =totalCarro(numeroHoras);
			}
		}
		
		
		return valorHoras;
					
	}
	
	public Double numeroHoras(Date fechaIngreso,Date fechaSalida) {
		
		double num = ((((fechaIngreso.getTime() - fechaSalida.getTime())/1000)/3600));
		return num;
	}
	
	public void validarFechaSalida(Date fechaSalida) {
		if(fechaSalida.equals(null))
			throw new ExcepcionTotalVacio(ticketConstante.TOTAL_SALIDA_VACIA);	
	}
	
	public void validarTotal(Double total) {
		if(total == 0.0)
			throw new ExcepcionTotalVacio(ticketConstante.TOTAL_SALIDA_VACIA);	
	}
}
