package Tema2_PilasYColas;

import com.sun.source.tree.BreakTree;

public class Ejercicios {

    // Primer Parcial - 25 de Marzo de 2022 - Ejercicio 1

    /**
     * Comprueba si los elementos de la pila están ordenados de manera estrictamente ascendente.
     *
     * @param pila
     * @return true si los elementos de la pila están ordenados ascendentemente (sin elementos repetidos),
     * y false en cualquier otro caso.
     */
    public boolean comprobarOrdenacion(Pila pila) {
        return comprobarOrdenacion(pila, -1);
    }

    private boolean comprobarOrdenacion(Pila pila, int anterior) {
        boolean resultado = true;
        if (!pila.vacia()) {
            int elemento = pila.desapilar();
            if (elemento > anterior)
                resultado = comprobarOrdenacion(pila, elemento);
            else resultado = false;
            pila.apilar(elemento);
        }
        return resultado;
    }

    // Primer Parcial - 22 de Abril de 2021 - Ejercicio 1

    /**
     * Elimina los elementos que se encuentran en las posiciones pares de la pila recibida como parámetro,
     * considerando que la cima ocupa la posición 1. Si la pila está vacía o tiene un único elemento quedará inalterada
     * y devolverá una pila vacía.
     *
     * @param pila
     * @return otra pila con los elementos eliminados en el mismo orden en el que se encontraban en la pila original
     */
    public Pila quitarPosicionesPares(Pila pila) {
        return this.quitarPosicionesPares(pila, 0);
    }

    private Pila quitarPosicionesPares(Pila pila, int posicion) {
        if (pila.vacia()) {
            return new Pila();
        } else {
            int elemento = pila.desapilar();
            posicion++;
            Pila resultado = this.quitarPosicionesPares(pila, posicion);
            if (posicion % 2 == 0) {
                resultado.apilar(elemento);
            } else {
                pila.apilar(elemento);
            }
            return resultado;
        }
    }

    // Ejercicio 1 pilas

    /**
     * Repite la misma pila n veces
     * @param pila
     * @param n Veces que se repite cada elemento
     * @return La misma pila en la que cada elemento de la pila original se repite n veces
     */
    public Pila repetirPila(Pila pila, int n){
        int dato = pila.desapilar();
        if (!pila.vacia()) {
            pila = repetirPila(pila, n);
        }
        for (int i = 0; i < n; i++){
            pila.apilar(dato);
        }
        return pila;
    }

    // Ejercicio 2 pilas
    private void eliminarDatoPila(Pila pila, int dato) {
        int elem;
        if (!pila.vacia()) {
            elem = pila.desapilar();
            if (elem != dato) {
                eliminarDatoPila(pila, dato);
                pila.apilar(elem);
            }
        }
    }

    public void apilarReorganizable(Pila pila, int dato) {
        eliminarDatoPila(pila, dato);
        pila.apilar(dato);
    }
}
