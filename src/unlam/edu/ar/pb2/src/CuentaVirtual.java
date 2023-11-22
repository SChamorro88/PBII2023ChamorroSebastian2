package unlam.edu.ar.pb2.src;

import java.util.List;
import java.util.Objects;

import unlam.edu.ar.pb2src.TipoMedio;

public class CuentaVirtual extends MedioPago implements Pagadora{
	private Integer cVU;
	private Double saldo;

	public CuentaVirtual(Integer cVU, TipoMedio tipoMedio, String nombreMedioDePago,Double saldo) {
		super(nombreMedioDePago, tipoMedio);
		this.cVU = cVU;
		this.saldo = saldo;
	}

	public Integer getcVU() {
		return cVU;
	}

	public void setcVU(Integer cVU) {
		this.cVU = cVU;
	}

	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cVU);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaVirtual other = (CuentaVirtual) obj;
		return Objects.equals(cVU, other.cVU);
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws MedioDePagoInexistenteException, PersonaNoExisteException, SaldoInsuficienteException {
		if (vendedor == null) {
			throw new PersonaNoExisteException("la persona no existe");
		}
		 if (getSaldo() < importe) {
			throw new SaldoInsuficienteException("su saldo es insuficiente");
		}
		
		 CuentaVirtual cuentaVirtual = buscarMedioDePagoVirtual(vendedor.getMediosDePago());
		 cuentaVirtual.setSaldo(getSaldo()+importe);
		 return true;
		
	}

	private CuentaVirtual buscarMedioDePagoVirtual(List<MedioPago> mediosDePago) throws MedioDePagoInexistenteException {
		for (MedioPago medioPago : mediosDePago) {
			MedioPago medioPagoActual = (CuentaVirtual) medioPago;
			return (CuentaVirtual) medioPagoActual;
		}
		throw new MedioDePagoInexistenteException("El medio de pago cuenta Virtual no existe");
	}

	}


		

