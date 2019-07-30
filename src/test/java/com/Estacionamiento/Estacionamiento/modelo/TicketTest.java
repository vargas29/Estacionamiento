package com.Estacionamiento.Estacionamiento.modelo;

import java.util.Date;

import org.junit.Test;

import com.Estacionamiento.Estacionamiento.BasePrueba;
import com.Estacionamiento.Estacionamiento.testdatabuilder.TicketTestDataBuillder;

import co.com.estacionamiento.dominio.constante.ticketConstante;
import co.com.estacionamiento.dominio.excepciones.ExcepcionCampoObligatorio;
import co.com.estacionamiento.dominio.excepciones.ExcepcionCilindraje;


public class TicketTest {

	@SuppressWarnings("deprecation")
	@Test
	public void validarPlacaObligatorio() {
		// Arrange
		TicketTestDataBuillder ticketTestDataBuillder = new TicketTestDataBuillder();
		ticketTestDataBuillder.conPlacaVehiculo(null);
		ticketTestDataBuillder.conFechaIngreso(new Date("29/03/2019"));
		ticketTestDataBuillder.conFechaSalida(new Date());
		// Act - Assert
		BasePrueba.assertThrows(() -> ticketTestDataBuillder.build(), ExcepcionCampoObligatorio.class,
				ticketConstante.LA_PLACA_DATO_OBLIGATORIO);
	}

	@Test
	public void validarTipoVehiculoObligatorio() {
		// Arrange
		TicketTestDataBuillder ticketTestDataBuillder = new TicketTestDataBuillder();
		ticketTestDataBuillder.conId(1);
		ticketTestDataBuillder.conTipoVehiculo(null);
		ticketTestDataBuillder.conTotal(0);
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
