package co.com.estacionamiento.infraestructura.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Entity
@Table(name="ticket")
@Data
public class ticketEntidad {
	
	@Id
	@TableGenerator(name = "id", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator  = "id")
	private int id;
	@Column
	private String tipoVehiculo;
	@Column
	private String placaVehiculo;
	@Column
	private Date fechaIngreso;
	@Column
	private Date fechaSalida;
	@Column
	private String cilindraje;
	@Column
	private double total;
	
	public ticketEntidad() {
		// TODO Auto-generated constructor stub
	}
	
	public ticketEntidad(int id, String tipoVehiculo, String placaVehiculo,Date fechaIngreso,Date fechaSalida, String cilindraje,double total) {
		this.id=id;
		this.tipoVehiculo=  tipoVehiculo;
		this.placaVehiculo = placaVehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cilindraje = cilindraje;
		this.total = total;
	}

}
