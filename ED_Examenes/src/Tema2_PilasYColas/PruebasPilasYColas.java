package Tema2_PilasYColas;

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
    }


}