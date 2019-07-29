package co.com.estacionamiento.dominio.excepciones;

public class ExcepcionTipoDeVehiculo extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionTipoDeVehiculo(String message) {
        super(message);
	}
}
