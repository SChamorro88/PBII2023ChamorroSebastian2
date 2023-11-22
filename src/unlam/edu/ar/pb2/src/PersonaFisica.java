package unlam.edu.ar.pb2.src;

import java.util.Objects;

public class PersonaFisica extends Persona {
	private Integer cUIL;
	private Integer edad;

	public PersonaFisica(Integer cUIL, String nombre2, String apellido2, Integer edad2) {
		super(nombre2, apellido2, edad2);
		this.cUIL =cUIL;
		this.edad = edad2;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getcUIL() {
		return cUIL;
	}

	public void setcUIL(Integer cUIL) {
		this.cUIL = cUIL;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cUIL);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaFisica other = (PersonaFisica) obj;
		return Objects.equals(cUIL, other.cUIL);
	}
	
	
	
}
