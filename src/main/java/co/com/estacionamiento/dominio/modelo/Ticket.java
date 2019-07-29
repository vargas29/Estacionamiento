package co.com.estacionamiento.dominio.modelo;

import java.util.Date;

import co.com.estacionamiento.dominio.modelo.ValidadorArgumento;
import lombok.Data;
import co.com.estacionamiento.dominio.constante.ticketConstante;;

@Data
public class Ticket {

	private int id;
	private String tipoVehiculo;
	private String placaVehiculo;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String cilindraje;
	private double total;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public Ticket (
	 int id,
	 String tipoVehiculo,
	 String placaVehiculo,
	 Date fechaIngreso,
	 Date fechaSalida,
	 String cilindraje,
	 double total) {
		
		ValidadorArgumento.validarCampoObligatorio(placaVehiculo, ticketConstante.LA_PLACA_DATO_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(tipoVehiculo, ticketConstante.EL_TIPO_VEHICULO_DATO_OBLIGATORIO);
		ValidadorArgumento.validarVehiculoMoto(cilindraje, tipoVehiculo, ticketConstante.EL_CILINDRAJE_DATO_OBLIGATORIO);
		
		
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placaVehiculo = placaVehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cilindraje = cilindraje;
		this.total = total;
	}
}
