package Tema2_PilasYColas;

public class Ejercicios {

    // Primer Parcial - 25 de Marzo de 2022 - Ejercicio 1
    /**
     * Comprueba si los elementos de la pila están ordenados de manera estrictamente ascendente.
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
}
