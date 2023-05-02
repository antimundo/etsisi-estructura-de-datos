package arbolBusqueda;

public class NodoArbol {

	private Alumno dato;
	private NodoArbol izquierdo;
	private NodoArbol derecho;

	// Constructor con dato
	public NodoArbol(Alumno dato) {
		this.dato = dato;
		izquierdo = null;
		derecho = null;
	}

	public NodoArbol getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(NodoArbol izquierdo) {
		this.izquierdo = izquierdo;
	}

	public NodoArbol getDerecho() {
		return derecho;
	}

	public void setDerecho(NodoArbol derecho) {
		this.derecho = derecho;
	}

	public Alumno getDato() {
		return dato;
	}

	public void setDato(Alumno dato) {
		this.dato = dato;
	}
}