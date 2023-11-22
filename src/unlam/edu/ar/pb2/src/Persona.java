package unlam.edu.ar.pb2.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persona {
	private String nombre;
	private String apellido;
	private Integer edad; 
	private List<MedioPago> mediosDePago;
	
	public Persona(String nombre,String apellido,Integer edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.mediosDePago = new ArrayList<MedioPago>();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void asociarMedioDePago(MedioPago medioPago) {
		mediosDePago.add(medioPago);
	}

	public List<MedioPago> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(List<MedioPago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}
	
	
	
	
}
