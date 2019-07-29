package co.com.estacionamiento.dominio.constante;


public class ticketConstante {
	
	//Constantes para Tabla de precios
	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_DIA_CARRO = 8000;
	public static final int VALOR_HORA_MOTO = 500;
	public static final int VALOR_CC_MAYOR_500 = 2000;
	public static final int VALOR_DIA_MOTO = 4000;
	
	public static final String TIPO_VEHICULO_CARRO = "Carro";
	public static final String TIPO_VEHICULO_MOTO = "Moto";
	
	//Cantidad de vehiculos
	public static final int NUMERO_MOTOS =10;
	public static final int NUMERO_CARROS =20;
	public static final int NUMERO_TOTAL_VEHICULOS =30;
	
	//Datos Obligatorios
	public static final String LA_PLACA_DATO_OBLIGATORIO="La Placa es obligatoria para registrar entrada";
	public static final String EL_TIPO_VEHICULO_DATO_OBLIGATORIO="El tipo de vehiculo es obligatoria para registrar entrada";
	public static final String LA_FECHA_INGRESO_DATO_OBLIGATORIO="La Fecha y hora de ingreso es obligatoria para registrar entrada";
	public static final String EL_CILINDRAJE_DATO_OBLIGATORIO="El Cilindraje de la moto es obligatoria para registrar entrada";
	
	//DatosPruebas
	public static final String NUMERO_PLACA="CBP123";
	public static final boolean ESTADO_CUPO_DISPONIBLE= true;
	
	//Validaciones
	public static final String LA_PLACA_SE_ENCUENTRA_REGISTRADA="Este vehiculo ya se encuentra en el estacionamiento";
	public static final String VALOR_HORA_CILINDRAJE_MAYOR_500= "El Valor de la hora es de 2000 por ser cilindraje mayor a 500 ";
	public static final String PLACA_INICIAN_LETRA_A = "No Pueden ingresar Este tipo de placa el dia de hoy";
	public static final String NO_EXISTE_CUPOS_DISPONIBLES_TIPO_VEHICULO = "No Existe cupos disponibles para este tipo den vehiculo";
	public static final String TIPO_DE_VHICULO_NO_DISPONIBLE="Este tipo de vehiculo no se puede registrar";
	public static final String NO_EXISTE_CUPOS= "No Existe cupos disponible";

}