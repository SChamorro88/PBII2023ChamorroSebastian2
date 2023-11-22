package unlam.edu.ar.pb2.src;

public interface Transferible {
	Double getSaldo();
	void depositar (Double importe);
	Boolean extraer(Double importe);

}
