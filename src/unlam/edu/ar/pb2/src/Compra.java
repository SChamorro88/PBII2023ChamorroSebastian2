package unlam.edu.ar.pb2.src;

public class Compra {
	private Persona vendedor;
	private Persona cliente;
	private MedioPago medioPago;


	public Compra(Persona vendedor, Persona cliente, MedioPago medioPago) {
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.medioPago = medioPago;
	}


	public Persona getVendedor() {
		return vendedor;
	}


	public void setVendedor(Persona vendedor) {
		this.vendedor = vendedor;
	}


	public Persona getCliente() {
		return cliente;
	}


	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}


	public MedioPago getMedioPago() {
		return medioPago;
	}


	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	
		
	}


	
	

