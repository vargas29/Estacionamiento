package co.com.estacionamiento.dominio.modelo;

import co.com.estacionamiento.dominio.excepciones.*;
import co.com.estacionamiento.dominio.constante.ticketConstante;

public class ValidadorArgumento {
	
	private ValidadorArgumento() {}

    public static void validarCampoObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionCampoObligatorio(mensaje);
        }
    }

    public static void validarVehiculoMoto(Object valor,String tipoVehiculo, String mensaje) {
        if (tipoVehiculo.equals(ticketConstante.TIPO_VEHICULO_MOTO)  && valor == null) {
        		  throw new ExcepcionCilindraje(mensaje);
        }
    }
    
}
