package Tema3_Listas;

import Tema2_PilasYColas.Cola;
import Tema2_PilasYColas.Ejercicios;
import Tema2_PilasYColas.Pila;

public class PruebasListas {
    public static void main(String[] args) {
        // Primer Parcial - 25 de Marzo de 2022 - Ejercicio 2
        ListaOrdinal miLista = new ListaOrdinal();
        miLista.insertar(1);
        miLista.insertar(2);
        miLista.insertar(3);
        miLista.mostrar();

        System.out.println("Comprobar moverAlFinal(): ");
        miLista.moverAlFinal(1);
        miLista.mostrar();
    }
}