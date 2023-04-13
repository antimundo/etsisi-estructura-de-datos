package Tema2_PilasYColas;

import Tema3_Listas.ListaOrdinal;

public class PruebasPilasYColas {
    public static void main(String[] args) {
        // Primer Parcial - 25 de Marzo de 2022 - Ejercicio 1
        Pila miPila = new Pila();
        miPila.apilar(3);
        miPila.apilar(2);
        miPila.apilar(1);
        miPila.mostrar();
        Ejercicios ejercicios = new Ejercicios();
        System.out.println("comprobarOrdenacion(miPila): " + ejercicios.comprobarOrdenacion(miPila));

        // Segundo Parcial - 25 de Marzo de 2022 - Ejercicio 2
        System.out.println("quitarPosicionesPares(miPila): ");
        miPila = new Pila();
        miPila.apilar(1);
        miPila.apilar(2);
        miPila.apilar(3);
        miPila.mostrar();
        Pila pares = ejercicios.quitarPosicionesPares(miPila);
        pares.mostrar();

        // Ejercicio 1 pilas
        miPila = new Pila();
        miPila.apilar(1);
        miPila.apilar(2);
        miPila.apilar(3);
        miPila.mostrar();
        miPila = ejercicios.repetirPila(miPila, 2);
        miPila.mostrar();
    }


}