package arbolNario;

public class NodoArbolNario {

	private int dato;
	private ListaNodosArbolNario hijos;

	public NodoArbolNario(int dato) {
		this.dato = dato;
		hijos = new ListaNodosArbolNario();
	}

	public int getDato() {
		return dato;
	}

	public ListaNodosArbolNario getHijos() {
		return hijos;
	}
}
