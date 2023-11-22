package unlam.edu.ar.pb2.test;

import static org.junit.Assert.*;

import java.security.interfaces.DSAKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import unlam.edu.ar.pb2.src.Billetera;
import unlam.edu.ar.pb2.src.Compra;
import unlam.edu.ar.pb2.src.CuentaBancaria;
import unlam.edu.ar.pb2.src.CuentaVirtual;
import unlam.edu.ar.pb2.src.MedioDePagoInexistenteException;
import unlam.edu.ar.pb2.src.MedioPago;
import unlam.edu.ar.pb2.src.Persona;
import unlam.edu.ar.pb2.src.PersonaFisica;
import unlam.edu.ar.pb2.src.PersonaJuridica;
import unlam.edu.ar.pb2.src.PersonaNoExisteException;
import unlam.edu.ar.pb2.src.SaldoInsuficienteException;
import unlam.edu.ar.pb2.src.Transaccion;
import unlam.edu.ar.pb2src.TipoMedio;

public class TestBilletera {
	private Transaccion transaccion;
	private Persona vendedor;
	private Persona cliente;
	private MedioPago cuentaBancaria;
	private Compra compra;
	
	private Billetera billetera;
	@Before 
	public void SetUp() {
		String nombreBilletera = "Money bank";
		billetera = new Billetera(nombreBilletera);
		
		String nombre = "Juan";
		String apellido = "Gomez";
		Integer edad = 45;
		Integer CUIT = 674435653;
		vendedor = new PersonaJuridica(CUIT,nombre,apellido,edad);
		
		String nombre2 = "Maria";
		String apellido2 = "Gomez";
		Integer edad2 = 55;
		Integer CUIL = 21321414;
		cliente  = new PersonaFisica(CUIL,nombre2,apellido2,edad2);
		
		String nombreMedioDePago = "Cuenta Bancaria";
		TipoMedio tipoMedio = TipoMedio.CUENTA_BANCARIA;
		Integer CBU = 1243252322;
		cuentaBancaria = new CuentaBancaria(nombre,tipoMedio,CBU, 200000.0);
		
		compra = new Compra(vendedor,cliente,cuentaBancaria);
		
		LocalDate fechaTrasaccion = LocalDate.of(2023,11,22);
		transaccion = new Transaccion (fechaTrasaccion,vendedor,cliente);
	}

	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDeTransacciones() throws Exception {
		//cuentaBancaria
		billetera.almacenarTransaccion(transaccion, cuentaBancaria);
		
		//cuentaVirtual
		Integer CVU = 23214431;
		TipoMedio tipoMedio = TipoMedio.CUENTA_VIRTUAL;
		String nombreMedioDePago = "Cuenta Virtual";
		MedioPago cuentaVirtual = new CuentaVirtual(CVU,tipoMedio,nombreMedioDePago,43432.0);
		
		LocalDate fechaTrasaccion = LocalDate.of(2023,11,22);
		Transaccion transaccion2 = new Transaccion(fechaTrasaccion, vendedor, cliente);
		
		billetera.almacenarTransaccion(transaccion2,cuentaVirtual);
		
		Transaccion valorObtenido = billetera.obtenerTransaccion(transaccion);
		Transaccion valorEsperado = transaccion;
		
		assertEquals(valorEsperado, valorObtenido);
		
		
	}
	
	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDePersonas() {
		billetera.almacenarPersona(vendedor);
		billetera.almacenarPersona(cliente);
		
		Integer valorObtenido = billetera.obtenerCantidadPersonas(); 
		Integer valorEsperado = 2;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
	public void queSePuedanAsociadACadaPersonaSusMedios () throws PersonaNoExisteException, MedioDePagoInexistenteException {
		Integer CVU = 23214431;
		TipoMedio tipoMedio = TipoMedio.CUENTA_VIRTUAL;
		String nombreMedioDePago = "Cuenta Virtual";
		MedioPago cuentaVirtual = new CuentaVirtual(CVU,tipoMedio,nombreMedioDePago,20203.0);
		

		String nombreMedioDePago2 = "Cuenta Bancaria";
		TipoMedio tipoMedio2 = TipoMedio.CUENTA_BANCARIA;
		Integer CBU = 1243252322;
		cuentaBancaria = new CuentaBancaria(nombreMedioDePago2,tipoMedio2,CBU, 200000.0);
		
		billetera.asociarMediosAPersona(cliente, cuentaVirtual);
		billetera.asociarMediosAPersona(cliente, cuentaBancaria);
		
		// para si la lista coincide con los medios de pago asociados, use una lista
		List<MedioPago>valorEsperado = new ArrayList<MedioPago>();
		valorEsperado.add(cuentaVirtual);
		valorEsperado.add(cuentaBancaria);
		
		assertEquals(valorEsperado, billetera.obtenerMediosDePagoDePersona(cliente));
		
	}
	
	@Test
	public void queSePuedanRealizarCompras () throws MedioDePagoInexistenteException, PersonaNoExisteException, SaldoInsuficienteException {
		Integer CVU = 23214431;
		TipoMedio tipoMedio = TipoMedio.CUENTA_VIRTUAL;
		String nombreMedioDePago = "Cuenta Virtual";
		MedioPago cuentaVendedor = new CuentaVirtual(CVU,tipoMedio,nombreMedioDePago, 21321.0);
		Integer CVU2 = 2156465;
		
		TipoMedio tipoMedio2 = TipoMedio.CUENTA_VIRTUAL;
		String nombreMedioDePago2 = "Cuenta Virtual";
		MedioPago cuentaCliente = new CuentaVirtual(CVU2,tipoMedio2,nombreMedioDePago2, 5656.0);
		
		vendedor.asociarMedioDePago(cuentaVendedor);
		cliente.asociarMedioDePago(cuentaCliente);
		
		 CuentaVirtual cuentaVirtualCliente = (CuentaVirtual) billetera.seleccionarMedioDePagoPersona(cliente);
		 CuentaVirtual cuentaVirutalVendedor = (CuentaVirtual) billetera.seleccionarMedioDePagoPersona(vendedor);
		 cuentaVirtualCliente.pagar(vendedor, 2000.0);
		 
		 Double valorObtenido = (Double) cuentaVirutalVendedor.getSaldo();
		 Double valorEsperado = 7656.0;
		 assertEquals(valorEsperado, valorObtenido);
	
	}
	
	
	@Test (expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaVirtualEsInsuficienteParaHacerUnaCompra() throws MedioDePagoInexistenteException, PersonaNoExisteException, SaldoInsuficienteException {
		Integer CVU = 23214431;
		TipoMedio tipoMedio = TipoMedio.CUENTA_VIRTUAL;
		String nombreMedioDePago = "Cuenta Virtual";
		MedioPago cuentaVendedor = new CuentaVirtual(CVU,tipoMedio,nombreMedioDePago, 21321.0);
		Integer CVU2 = 2156465;
		
		TipoMedio tipoMedio2 = TipoMedio.CUENTA_VIRTUAL;
		String nombreMedioDePago2 = "Cuenta Virtual";
		MedioPago cuentaCliente = new CuentaVirtual(CVU2,tipoMedio2,nombreMedioDePago2, 5656.0);
		
		vendedor.asociarMedioDePago(cuentaVendedor);
		cliente.asociarMedioDePago(cuentaCliente);
		
		 CuentaVirtual cuentaVirtualCliente = (CuentaVirtual) billetera.seleccionarMedioDePagoPersona(cliente);
		 CuentaVirtual cuentaVirutalVendedor = (CuentaVirtual) billetera.seleccionarMedioDePagoPersona(vendedor);
		 cuentaVirtualCliente.pagar(vendedor, 8000.0);
		 
		 Double valorObtenido = (Double) cuentaVirutalVendedor.getSaldo();
		 Double valorEsperado = 7656.0;
		 assertEquals(valorEsperado, valorObtenido);
	
	}


}
