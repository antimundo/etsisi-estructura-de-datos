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

        // Ejercicio 2 pilas
        System.out.println("Ejercicio 2 pilas");
        miPila = new Pila();
        miPila.apilar(1);
        miPila.apilar(2);
        miPila.apilar(3);
        miPila.apilar(4);
        miPila.mostrar();
        ejercicios.apilarReorganizable(miPila, 3);
        miPila.mostrar();

        // Ejercicio 5 pilas
        System.out.println("Ejercicio 5 pilas");
        miPila = new Pila();
        miPila.apilar(1);
        miPila.apilar(2);
        miPila.apilar(3);
        miPila.mostrar();
        ejercicios.moverElementoFondo(miPila);
        miPila.mostrar();

        // Ejercicio 2 colas
        System.out.println("Ejercicio 2 colas");
        Cola miCola = new Cola();
        miCola.encolar(1);
        miCola.encolar(2);
        miCola.encolar(3);
        miCola.mostrar();
        System.out.println("Posición del 2: " + ejercicios.posicionEnCola(miCola, 2));
        miCola.mostrar();
    }
}