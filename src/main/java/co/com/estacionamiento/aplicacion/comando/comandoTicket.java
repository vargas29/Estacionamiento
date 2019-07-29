package co.com.estacionamiento.aplicacion.comando;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class comandoTicket {

	private int id;
	private String tipoVehiculo;
	private String placaVehiculo;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String cilindraje;
	private double total;
	
}
