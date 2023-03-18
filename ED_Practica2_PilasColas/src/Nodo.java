/**
 * Clase Nodo, define el nodo de la Pila y la Cola
 *
 * @author Pilar Martínez García
 * @version 1.0
 *
 * Modificar para que el nodo contenga como datos Strings en vez de int
 */
public class Nodo{
    /**
     * dato que contiene el nodo de la pila o cola
     */
    private String dato;
    /**
     * referencia al siguiente elemento de la lista
     */
    private Nodo siguiente;

    /**
     * Instancia un nuevo nodo para insertarlo en una pila o cola
     *
     * @param dato contenido del nodo
     * @param siguiente referencia al siguiente elemento de la lista
     */
    public Nodo(String dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * Devuelve la referencia al siguiente elemento de la lista
     * @return siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * pone como nodo siguiente el que recibe como argumento
     * @param siguiente nueva referencia que se quiere enlazar en la lista
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * devuelve el dato contenido en el nodo
     * @return dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * modifica el dato contenido en el nodo con el valor que se recibe como argumento
     * @param dato nuevo dato que se almacenará en el nodo
     */
    public void setDato(String dato) {
        this.dato = dato;
    }
}
