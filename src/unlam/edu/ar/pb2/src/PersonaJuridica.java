package unlam.edu.ar.pb2.src;

import java.util.Objects;

public class PersonaJuridica extends Persona {
	private Integer cUIT;

	public PersonaJuridica(Integer cUIT, String nombre, String apellido, Integer edad) {
		super(nombre, apellido, edad);
		this.cUIT = cUIT;
	}

	public Integer getcUIT() {
		return cUIT;
	}

	public void setcUIT(Integer cUIT) {
		this.cUIT = cUIT;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cUIT);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaJuridica other = (PersonaJuridica) obj;
		return Objects.equals(cUIT, other.cUIT);
	}

	
}
