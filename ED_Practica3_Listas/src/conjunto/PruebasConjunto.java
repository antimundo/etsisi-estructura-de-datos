package conjunto;

public class PruebasConjunto {

    public static void main(String[] args) {
        Conjunto conjunto = new Conjunto();
        conjunto.insertar(4);
        conjunto.insertar(6);
        conjunto.insertar(2);
        conjunto.insertar(4);
        conjunto.insertar(-2);
        System.out.print("# Conjunto pasado a array: ");
        conjunto.mostrar();

        int[] array = conjunto.toArray();
        System.out.print("# Conjunto pasado a array: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("# El mayor de los elementos del conjunto es: " + conjunto.mayor());

        Conjunto subconjunto = conjunto.subconjunto(3, 6);
        System.out.print("\n# El subconjunto entre 3 y 6 del conjunto es: ");
        subconjunto.mostrar();

        Conjunto conjunto2 = new Conjunto();
        conjunto2.insertar(2);
        conjunto2.insertar(4);
        System.out.print("\nConjunto 2: ");
        conjunto2.mostrar();

        System.out.println("¿Son iguales los conjuntos? " + conjunto2.equals(conjunto));

        conjunto2.insertar(6);
        System.out.print("\nConjunto 2 actualizado: ");
        conjunto2.mostrar();

        System.out.println("¿Son iguales los conjuntos? " + conjunto2.equals(conjunto));

        System.out.println("\n# Pruebas algoritmos");
        Conjunto nuevo = new Conjunto();
        nuevo.insertar(4);
        nuevo.insertar(5);
        Conjunto resultado = new Algoritmos().interseccion(nuevo, conjunto);
        System.out.print("## Resultado de la interseccion entre el conjunto ");
        nuevo.mostrar();
        System.out.print(" y el conjunto ");
        conjunto.mostrar();
        System.out.print(" es:  ");
        resultado.mostrar();
    }

}
