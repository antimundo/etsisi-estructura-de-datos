package arbolNario;

public class NodoListaNodosArbolNario {

	private NodoArbolNario dato;
	private NodoListaNodosArbolNario anterior;
	private NodoListaNodosArbolNario siguiente;

	public NodoListaNodosArbolNario(NodoArbolNario dato,
                                    NodoListaNodosArbolNario anterior,
                                    NodoListaNodosArbolNario siguiente) {
		this.dato = dato;
		this.anterior = anterior;
		this.siguiente = siguiente;
	}

	public NodoArbolNario getDato() {
		return dato;
	}

	public void setDato(NodoArbolNario dato) {
		this.dato = dato;
	}

	public NodoListaNodosArbolNario getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoListaNodosArbolNario anterior) {
		this.anterior = anterior;
	}

	public NodoListaNodosArbolNario getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaNodosArbolNario siguiente) {
		this.siguiente = siguiente;
	}
}
