package arbolNario;

public class IteradorAtrasListaNodosArbolNario {

	private NodoListaNodosArbolNario actual;

	public IteradorAtrasListaNodosArbolNario(
			NodoListaNodosArbolNario comienzo) {
		actual = comienzo;
	}

	public boolean hasPrevious() {
		return actual != null;
	}

	public NodoArbolNario previous() {
		NodoArbolNario resultado = actual.getDato();
		actual = actual.getAnterior();
		return resultado;
	}
}
