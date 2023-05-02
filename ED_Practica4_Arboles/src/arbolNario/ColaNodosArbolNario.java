package arbolNario;

public class ColaNodosArbolNario {

	private NodoListaNodosArbolNario cabeza, fin;
	private int numElementos;

	public ColaNodosArbolNario() {
		cabeza = null;
		fin = null;
		numElementos = 0;
	}

	/**
	 * Determina si la cola está vacía o no
	 */
	public boolean vacia() {
		return cabeza == null;
	}

	/**
	 * Coloca el dato al final de la cola, si es posible.
	 */
	public void encolar(NodoArbolNario dato) {
		NodoListaNodosArbolNario nuevo = new NodoListaNodosArbolNario(dato,
				null, null);
		if (!this.vacia()) {
			fin.setSiguiente(nuevo);
		} else {
			cabeza = nuevo;
		}
		fin = nuevo;
		numElementos++;
	}

	/**
	 * Elimina el primer elemento de la cola y lo devuelve, si es posible.
	 */
	public NodoArbolNario desencolar() {
		NodoArbolNario valor;
		if (this.vacia()) {
			System.out.println("Error, la cola está vacía");
			valor = null;
		} else {
			valor = cabeza.getDato();
			cabeza = cabeza.getSiguiente();
			if (cabeza == null) {  // La cola se queda vacía
				fin = null;
			}
			numElementos--;
		}
		return valor;
	}

	/**
	 * Devuelve el primer elemento de la cola sin eliminarlo, si es posible.
	 */
	public NodoArbolNario getCabeza() {
		NodoArbolNario valor;
		if (!this.vacia()) {
			valor = cabeza.getDato();
		} else {
			System.out.println("Error, la cola está vacía");
			valor = null;
		}
		return valor;
	}

	/**
	 * Devuelve el número de elementos que contiene la cola
	 */
	public int getNumElementos() {
		return numElementos;
	}
}
