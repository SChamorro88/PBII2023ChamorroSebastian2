package unlam.edu.ar.pb2.src;

import java.util.Objects;

import unlam.edu.ar.pb2src.TipoMedio;

public class CuentaBancaria extends MedioPago implements Pagadora {
	private Integer cBU;
	private Double saldo;
	public CuentaBancaria(String nombre, TipoMedio tipoMedio, Integer cBU, Double saldo) {
		super(nombre, tipoMedio);
			this.cBU = cBU;
			this.setSaldo(saldo);
	}
	
	public Integer getcBU() {
		return cBU;
	}
	public void setcBU(Integer cBU) {
		this.cBU = cBU;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cBU);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		return Objects.equals(cBU, other.cBU);
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws PersonaNoExisteException, SaldoInsuficienteException {
		return null;
	}
	
	

}
