package Tema2_PilasYColas;

public class Pila {
    /**
     * Referencia al primer nodo de la pila
     */
    private Nodo cima;
    /**
     * Número de elementos que contiene la pila
     */
    private int numElementos;

    /**
     * Constructor de la clase, prepara la pila para su uso
     */
    public Pila() {
        cima = null;
        numElementos = 0;
    }

    /**
     * Método que verifica si la pila tiene algún elemento
     * @return true si está vacía, false si tiene elementos
     */
    public boolean vacia() {
        return cima == null;
    }

    /**
     * Método que inserta un nuevo elemento en la cima de la pila
     * @param dato el elemento a insertar
     */
    public void apilar(int dato) {
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo;
        numElementos++;
    }

    /**
     * Método que extrae de la pila el elemento que aparece en la cima
     * @return el primer elemento de la pila. Devuelve una cadena vacía si la cola está vacía
     */
    public int desapilar() {
        int valor = -9999;
        if (this.vacia()) {
            System.out.println("Error, la pila está vacía");
        } else {
            valor = cima.getDato();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    /**
     * Método para comprobar el número de elementos que contiene la pila
     * @return el número de elementos que contiene la pila
     */
    public int getNumElementos() {
        return numElementos;
    }

    /**
     * Método que muestra por pantalla el contenido de la pila
     */
    public void mostrar() {
        Nodo auxiliar = cima;
        System.out.println("Contenido de la pila: ");
        while (auxiliar != null) {
            System.out.print(auxiliar.getDato() + ", ");
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println("FIN");
    }
}
