package Tema3_Listas;

public class Iterador {
    private Nodo actual;

    public Iterador(Nodo actual) {
        this.actual = actual;
    }

    public boolean hasNext() {
        return actual != null;
    }

    public int next() {
        int resultado = actual.getDato();
        actual = actual.getSiguiente();
        return resultado;
    }
}
