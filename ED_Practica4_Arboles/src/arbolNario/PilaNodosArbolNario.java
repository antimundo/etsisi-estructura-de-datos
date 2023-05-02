package arbolNario;

public class PilaNodosArbolNario {

	private NodoListaNodosArbolNario cima;
	private int numElementos;

	public PilaNodosArbolNario() {
		cima = null;
		numElementos = 0;
	}

	public boolean vacia() {
		return cima == null;
	}

	/**
	 * Apila el dato en la cima de la pila
	 */
	public void apilar(NodoArbolNario dato) {
		NodoListaNodosArbolNario nuevo = new NodoListaNodosArbolNario(dato,
				null, cima);
		cima = nuevo;
		numElementos++;
	}

	/**
	 * Elimina la cima de la pila si existe, y devuelve como resultado dicho
	 * dato.
	 */
	public NodoArbolNario desapilar() {
		NodoArbolNario valor;
		if (this.vacia()) {
			System.out.println("Error, la pila está vacía");
			valor = null;
		} else {
			valor = cima.getDato();
			cima = cima.getSiguiente();
			numElementos--;
		}
		return valor;
	}

	/**
	 * Devuelve la cima de la pila sin desapilarla
	 */
	public NodoArbolNario getCima() {
		NodoArbolNario valor;
		if (this.vacia()) {
			System.out.println("Error, la pila está vacía");
			valor = null;
		} else {
			valor = cima.getDato();
		}
		return valor;
	}

	/**
	 * Elimina el elemento de la cima de la pila
	 */
	public void quitarCima() {
		if (this.vacia()) {
			System.out.println("Error, la pila está vacía");
		} else {
			cima = cima.getSiguiente();
			numElementos--;
		}
	}

	/**
	 * Devuelve el número de elementos que contiene la pila
	 */
	public int getNumElementos() {
		return numElementos;
	}
}
