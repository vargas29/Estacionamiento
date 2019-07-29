package co.com.estacionamiento.dominio.excepciones;

public class ExcepcionExistenciaEstacionamiento extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ExcepcionExistenciaEstacionamiento(String message) {
        super(message);
	}
}
