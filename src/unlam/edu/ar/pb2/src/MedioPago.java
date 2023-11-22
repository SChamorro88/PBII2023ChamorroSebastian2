package unlam.edu.ar.pb2.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import unlam.edu.ar.pb2src.TipoMedio;

public class MedioPago {
	private String nombre; 
	private TipoMedio tipoMedio;
	private List<MedioPago>listaDeMedioDePago;
	
	public MedioPago(String nombre, TipoMedio tipoMedio) {
		super();
		this.nombre = nombre;
		this.tipoMedio = tipoMedio;
		this.listaDeMedioDePago = new ArrayList<MedioPago>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoMedio getTipoMedio() {
		return tipoMedio;
	}

	public void setTipoMedio(TipoMedio tipoMedio) {
		this.tipoMedio = tipoMedio;
	}
	
	public void agregarMedioDePago(MedioPago medioPago) {
		this.listaDeMedioDePago.add(medioPago);
	}

	public CuentaVirtual buscarMedioDePago(MedioPago medioPago) throws MedioDePagoInexistenteException {
		for (MedioPago medioPago2 : listaDeMedioDePago) {
			if (medioPago2.equals(medioPago)) {
				return (CuentaVirtual) medioPago2;
			}
		}
		throw new MedioDePagoInexistenteException("La cuenta no existe");
	}

}
