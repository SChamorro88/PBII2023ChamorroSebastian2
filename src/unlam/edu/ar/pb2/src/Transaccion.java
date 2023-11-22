package unlam.edu.ar.pb2.src;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaccion {
	private LocalDate fechaTrassaccion;
	private Boolean estado; 
	private Persona vendedor;
	private Persona cliente;

	public Transaccion(LocalDate fechaTrasaccion, Persona vendedor, Persona cliente) {
		this.fechaTrassaccion = fechaTrasaccion;
		this.estado = false;
		this.cliente = cliente;
		this.vendedor = vendedor;
		
	}

	public LocalDate getFechaTrassaccion() {
		return fechaTrassaccion;
	}

	public void setFechaTrassaccion(LocalDate fechaTrassaccion) {
		this.fechaTrassaccion = fechaTrassaccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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

	
	
	

}
