package unlam.edu.ar.pb2.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unlam.edu.ar.pb2src.TipoMedio;

public class Billetera {
	private String nombreBilletera;
	private Map<Transaccion, MedioPago> transacciones;
	private List<Persona>personas;
	
	public Billetera(String nombreBilletera) {
		this.nombreBilletera = nombreBilletera;
		this.transacciones = new HashMap<Transaccion, MedioPago>();
		this.personas = new ArrayList<Persona>();
	}

	public void almacenarTransaccion(Transaccion transaccion, MedioPago medioPago) throws PersonaNoExisteException {
		if (transaccion.getCliente() == null) {
			throw new PersonaNoExisteException("El Cliente no existe");
		} else if (transaccion.getVendedor() == null) {
			throw new PersonaNoExisteException("El Vendedor no existe");
		}
		
		transacciones.put(transaccion, medioPago);
		transaccion.setEstado(true);
		
		
	}
	
	public Transaccion obtenerTransaccion(Transaccion transaccion) throws Exception {
		Transaccion transaccionEncontrada = buscarTransaccion(transaccion);
		return transaccionEncontrada;
		
	}

	private Transaccion buscarTransaccion(Transaccion transaccion) throws Exception {
		for (Map.Entry<Transaccion, MedioPago> transacciones : transacciones.entrySet()) {
			Transaccion transaccion1 = transacciones.getKey();
			MedioPago medioDePago = transacciones.getValue();
			
			if (transaccion1.equals(transaccion)) {
				return transaccion1;
			}
		}
		throw new Exception("No se encuentra la transaccion");
	}

	public void almacenarPersona(Persona persona) {
		this.personas.add(persona);
	}

	public Integer obtenerCantidadPersonas() {
		return this.personas.size();
	}

	public void asociarMediosAPersona(Persona persona, MedioPago medioPago) throws PersonaNoExisteException, MedioDePagoInexistenteException {
		if (persona ==  null) {
			throw new PersonaNoExisteException("La persona no existe");
		}
		if (medioPago == null) {
			throw new MedioDePagoInexistenteException("Este medio de pago no existe");
		}
		
		persona.asociarMedioDePago(medioPago);
	};
	
	public List<MedioPago> obtenerMediosDePagoDePersona(Persona persona){
		List<MedioPago> mediosAsociados = new ArrayList<MedioPago>(persona.getMediosDePago());
		return mediosAsociados;
	}

	public void generarQR(Persona vendedor, MedioPago tipoCuenta) {
		
	}
	
	public MedioPago seleccionarMedioDePagoPersona(Persona persona) throws MedioDePagoInexistenteException {
		List<MedioPago> mediosAsociados = new ArrayList<MedioPago>(persona.getMediosDePago());
		for (MedioPago medioPago : mediosAsociados) {
			medioPago.getTipoMedio();
			if (TipoMedio.CUENTA_VIRTUAL.equals(medioPago.getTipoMedio().CUENTA_VIRTUAL)) {
				return (CuentaVirtual) medioPago;
			}
		}
		 throw new MedioDePagoInexistenteException("el medio de pago seleccionado no existe");
	}

}
