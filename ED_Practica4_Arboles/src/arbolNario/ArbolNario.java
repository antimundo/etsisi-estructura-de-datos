package arbolNario;

public class ArbolNario {

	private NodoArbolNario raiz;

	public ArbolNario(int dato) {
		raiz = new NodoArbolNario(dato);
	}

	public void insertar(ArbolNario arbol) {
		raiz.getHijos().insertar(arbol.raiz);
	}

	// ------------------------------------------------------------------------
	// TODO 2.2: Mostrar el arbol recorriendo en profundidad de forma RECURSIVA
	public void mostrarProfundidadRecursivo() {
		System.out.print("Profundidad Recursivo: ");
		mostrarProfundidadRecursivo(raiz);
		System.out.println();
	}
	private void mostrarProfundidadRecursivo(NodoArbolNario nodo){
		if (nodo != null){
			System.out.print(nodo.getDato() + " ");
			ListaNodosArbolNario hijos = nodo.getHijos();
			IteradorAdelanteListaNodosArbolNario it = hijos.getIteradorAdelante();
			while (it.hasNext()){
				mostrarProfundidadRecursivo(it.next());
			}
		}
	}

	// ------------------------------------------------------------------------
	// TODO 2.3: Mostrar el arbol recorriendo en profundidad de forma ITERATIVA
	public void mostrarProfundidadIterativo() {
		System.out.print("Profundidad Iterativo: ");
		mostrarProfundidadIterativo(raiz);
		System.out.println();
	}
	private void mostrarProfundidadIterativo(NodoArbolNario nodo){
		PilaNodosArbolNario pilaAux = new PilaNodosArbolNario();
		pilaAux.apilar(nodo);
		while (!pilaAux.vacia()){
			nodo = pilaAux.desapilar();
			System.out.print(nodo.getDato() + " ");
			ListaNodosArbolNario hijos = nodo.getHijos();
			IteradorAtrasListaNodosArbolNario it = hijos.getIteradorAtras();
			while (it.hasPrevious()){
				pilaAux.apilar(it.previous());
			}
		}
	}

	// ------------------------------------------------------------------------
	// TODO 2.4: Mostrar el arbol recorriendo en amplitud de forma ITERATIVA
	public void mostrarAmplitud() {
		System.out.print("Amplitud: ");
		mostrarAmplitud(raiz);
		System.out.println();
	}

	private void mostrarAmplitud(NodoArbolNario nodo){
		ColaNodosArbolNario colaAux = new ColaNodosArbolNario();
		colaAux.encolar(nodo);
		while (!colaAux.vacia()){
			nodo = colaAux.desencolar();
			System.out.print(nodo.getDato() + " ");
			ListaNodosArbolNario hijos = nodo.getHijos();
			IteradorAdelanteListaNodosArbolNario it = hijos.getIteradorAdelante();
			while (it.hasNext()){
				colaAux.encolar(it.next());
			}
		}
	}
}