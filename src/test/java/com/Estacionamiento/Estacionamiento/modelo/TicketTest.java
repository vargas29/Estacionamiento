package com.Estacionamiento.Estacionamiento.modelo;

import org.junit.Test;

import com.Estacionamiento.Estacionamiento.BasePrueba;
import com.Estacionamiento.Estacionamiento.testdatabuilder.TicketTestDataBuillder;

import co.com.estacionamiento.dominio.constante.ticketConstante;
import co.com.estacionamiento.dominio.excepciones.ExcepcionCampoObligatorio;
import co.com.estacionamiento.dominio.excepciones.ExcepcionCilindraje;
import co.com.estacionamiento.dominio.excepciones.ExcepcionTipoDeVehiculo;
import co.com.estacionamiento.dominio.modelo.Ticket;

public class TicketTest {

	@Test
	public void validarPlacaObligatorio() {
		// Arrange
		TicketTestDataBuillder ticketTestDataBuillder = new TicketTestDataBuillder();
		ticketTestDataBuillder.conPlacaVehiculo(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> ticketTestDataBuillder.build(), ExcepcionCampoObligatorio.class,
				ticketConstante.LA_PLACA_DATO_OBLIGATORIO);
	}

	@Test
	public void validarTipoVehiculoObligatorio() {
		// Arrange
		TicketTestDataBuillder ticketTestDataBuillder = new TicketTestDataBuillder();
		ticketTestDataBuillder.conTipoVehiculo(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> ticketTestDataBuillder.build(), ExcepcionCampoObligatorio.class,
				ticketConstante.EL_TIPO_VEHICULO_DATO_OBLIGATORIO);
	}

	@Test
	public void validarCilindraje() {
		TicketTestDataBuillder ticketTestDataBuillder = new TicketTestDataBuillder();
		ticketTestDataBuillder.conCilindraje(null);
		ticketTestDataBuillder.conTipoVehiculo(ticketConstante.TIPO_VEHICULO_MOTO);

		// Act - Assert
		BasePrueba.assertThrows(() -> ticketTestDataBuillder.build(), ExcepcionCilindraje.class,
				ticketConstante.EL_CILINDRAJE_DATO_OBLIGATORIO);
	}



}
