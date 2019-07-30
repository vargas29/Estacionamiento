package co.com.estacionamiento.dominio.excepciones;

public class ExcepcionTotalVacio extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcepcionTotalVacio(String message) {
		super(message);
		}
	
}
