package co.com.estacionamiento.dominio.excepciones;

public class ExcepcionCilindraje extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ExcepcionCilindraje(String message) {
        super(message);
	}
}
