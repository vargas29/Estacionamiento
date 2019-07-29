package co.com.estacionamiento.dominio.excepciones;

public class ExcepcionCampoObligatorio extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionCampoObligatorio(String message) {
		super(message);
	}
	      
}
