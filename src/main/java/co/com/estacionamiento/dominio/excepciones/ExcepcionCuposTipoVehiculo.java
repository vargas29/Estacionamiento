package co.com.estacionamiento.dominio.excepciones;

public class ExcepcionCuposTipoVehiculo extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ExcepcionCuposTipoVehiculo(String message) {
        super(message);
	}
}
