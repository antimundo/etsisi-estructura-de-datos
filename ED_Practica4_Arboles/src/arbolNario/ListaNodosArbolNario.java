package arbolNario;

public class ListaNodosArbolNario {

	private NodoListaNodosArbolNario inicio, fin;
	private int numElementos;

	public ListaNodosArbolNario() {
		inicio = null;
		fin = null;
		numElementos = 0;
	}

	public boolean vacia() {
		return inicio == null;
	}

	/**
	 * Inserta el dato en la última posición de la lista
	 */
	public void insertar(NodoArbolNario dato) {
		NodoListaNodosArbolNario nuevo = new NodoListaNodosArbolNario(dato,
				fin, null);
		if (this.vacia()) {
			inicio = nuevo;
		} else {
			fin.setSiguiente(nuevo);
		}
		fin = nuevo;
		numElementos++;
	}

	/**
	 * Busca el dato que ocupa la posición recibida como parámetro, en caso de
	 * existir.
	 */
	public NodoArbolNario getElemento(int posicion) {
		NodoListaNodosArbolNario actual;
		if ((posicion > numElementos - 1) || (posicion < 0)) {
			System.out.println("No existe la posición " + posicion);
			return null;
		} else {
			actual = inicio;
			for (int i = 0; i < posicion; i++) {
				actual = actual.getSiguiente();
			}
			return actual.getDato();
		}
	}

	/**
	 * Borra el primer elemento de la lista cuyo dato coincide con el parámetro
	 * recibido.
	 */
	public void borrar(NodoArbolNario dato) {
		NodoListaNodosArbolNario actual = inicio;
		while (actual != null && actual.getDato() != dato) {
			actual = actual.getSiguiente();
		}
		if (actual != null) {  // Borrar actual
			NodoListaNodosArbolNario anterior = actual.getAnterior();
			NodoListaNodosArbolNario siguiente = actual.getSiguiente();
			if (actual.getDato() == dato) {  
				if (actual == inicio) {  // se borra el primero
					inicio = siguiente;
				} else {
					anterior.setSiguiente(siguiente);
				}
				if (actual == fin) {  // se borra el último
					fin = anterior;
				} else {
					siguiente.setAnterior(anterior);
				}
				numElementos--;
			}
		}
	}

	/**
	 * Devuelve la primera posición en la que se encuentra el dato, en caso de
	 * existir. En caso contrario, devuelve -1
	 */
	public int posicion(NodoArbolNario dato) {
		NodoListaNodosArbolNario actual = inicio;
		int pos = 0;
		while (actual != null && actual.getDato() != dato) {
			actual = actual.getSiguiente();
			pos++;
		}
		if (actual != null) {
			return pos;
		} else {
			return -1;
		}
	}

	/**
	 * Determina si el dato recibido como parámetro existe en la lista.
	 */
	public boolean contiene(NodoArbolNario dato) {
		return this.posicion(dato) >= 0;
	}

	/**
	 * Devuelve el numero de elementos de la lista.
	 */
	public int getNumElementos() {
		return numElementos;
	}

	/**
	 * Devuelve un iterador para recorrer la lista hacia adelante.
	 */
	public IteradorAdelanteListaNodosArbolNario getIteradorAdelante() {
		return new IteradorAdelanteListaNodosArbolNario(inicio);
	}

	/**
	 * Devuelve un iterador para recorrer la lista hacia atras.
	 */
	public IteradorAtrasListaNodosArbolNario getIteradorAtras() {
		return new IteradorAtrasListaNodosArbolNario(fin);
	}
}
