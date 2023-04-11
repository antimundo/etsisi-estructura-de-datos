package conjunto;

public class Algoritmos {
    public Conjunto interseccion(Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto resultado = new Conjunto();
        int[] conjunto1_1 = conjunto1.toArray();

        for (int i = 0; i < conjunto1.getNumElementos(); i++) {
            int x = conjunto1_1[i];
            if (conjunto2.contiene(x) && !resultado.contiene(x)) {
                resultado.insertar(x);
            }
        }
        return resultado;
    }


}
