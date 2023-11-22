package unlam.edu.ar.pb2.src;

public class PersonaNoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PersonaNoExisteException (String mensaje) {
		super(mensaje);
	}

}
