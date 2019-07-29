package co.com.estacionamiento.dominio.excepciones;

public class ExcepcionValidaCupoVehiculo extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionValidaCupoVehiculo(String message) {
		super(message);
	}
}
