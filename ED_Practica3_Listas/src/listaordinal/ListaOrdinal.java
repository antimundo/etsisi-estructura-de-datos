package listaordinal;

public class ListaOrdinal {
    private Nodo inicio, fin;
    private int numElementos;

    public ListaOrdinal() {
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
    public void insertar(Producto dato) {
        // Crear un nodo nuevo
        Nodo nuevo = new Nodo(dato, null);
        // Insertar el nodo al final de la lista enlazada
        if (this.vacia()) {
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        numElementos++;
    }


    /**
     * Busca el dato que ocupa la posición recibida como parámetro,
     * Si no existe esa posición, el resultado es impredecible.
     */
    public Producto getElemento(int posicion) {
        // Avanzar en la lista tantos elementos como el parámetro posicion
        Nodo actual = inicio;   // referencia auxiliar para recorrer la lista
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    /**
     * Borra el primer elemento de la lista cuyo dato coincide con el
     * parámetro recibido, si existe.
     */
    public boolean borrar(Producto dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual != null) {  // dato encontrado. Borrar nodo actual
            if (actual == inicio) {   // Borrar el primero de la lista
                inicio = actual.getSiguiente();
            } else {  // Borrar nodo que no es el primero
                anterior.setSiguiente(actual.getSiguiente());
            }
            if (actual == fin) {  // Se ha borrado el último de la lista
                fin = anterior;
            }
            numElementos--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve la primera posición en la que se encuentra el dato,
     * en caso de existir. En caso contrario, devuelve -1
     */
    public int posicion(Producto dato) {
        Nodo actual = inicio;
        int pos = 0;
        while (actual != null && !actual.getDato().equals(dato)) {
            actual = actual.getSiguiente();
            pos++;
        }
        if (actual != null) {  // Dato encontrado
            return pos;
        } else {
            return -1;
        }
    }

    /**
     * Determina si el dato recibido como parámetro existe en la lista.
     */
    public boolean contiene(Producto dato) {
        return this.posicion(dato) >= 0;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public Iterador getIterador() {
        return new Iterador(inicio);
    }

    public void mostrar() {
        if (this.vacia()) {
            System.out.println("Lista vacía");
        } else {
            Nodo actual = inicio;
            while (actual != null) {
                actual.getDato().mostrar();
                actual = actual.getSiguiente();
            }
            System.out.println();
        }
    }

}
