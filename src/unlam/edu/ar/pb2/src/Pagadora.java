package unlam.edu.ar.pb2.src;

public interface Pagadora {
	Boolean pagar(Persona vendedor,Double importe) throws PersonaNoExisteException, SaldoInsuficienteException, MedioDePagoInexistenteException;
}
