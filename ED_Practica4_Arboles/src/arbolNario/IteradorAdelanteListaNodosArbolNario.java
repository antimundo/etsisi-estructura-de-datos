package arbolNario;

public class IteradorAdelanteListaNodosArbolNario {

	private NodoListaNodosArbolNario actual;

	public IteradorAdelanteListaNodosArbolNario(
			NodoListaNodosArbolNario comienzo) {
		actual = comienzo;
	}

	public boolean hasNext() {
		return actual != null;
	}

	public NodoArbolNario next() {
		NodoArbolNario resultado = actual.getDato();
		actual = actual.getSiguiente();
		return resultado;
	}
}
