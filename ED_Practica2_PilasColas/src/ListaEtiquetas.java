/**
 * Clase ListaEtiquetas, que gestiona una lista de etiquetas en html
 * Esta clase se entrega completamente desarrollada, no se tiene que modificar
 *
 * @author Pilar Martinez Garcia
 * @version 1.0
 */
public class ListaEtiquetas {
    /**
     * El vector que contiene los elementos de tipo Etiqueta
     */
    private Etiqueta[] lista;
    /**
     * El número de elementos que contiene la lista
     */
    private int numEtiquetas;
    /**
     * Tamaño del vector que almacena la lista
     */
    private final int MAXIMO;

    /**
     * Constructor de la clase, que prepara la lista para usarla
     * @param maximo tamaño del vector
     * @param datos array de String que contiene los elementos que se van a insertar en la lista
     */
    public ListaEtiquetas(int maximo, String[] datos) {
        MAXIMO = maximo;
        numEtiquetas = 0;
        lista = new Etiqueta[maximo];
        for (int i = 0; i < datos.length; i++) {
            lista[i] = new Etiqueta(datos[i]);
        }
        numEtiquetas = datos.length;
    }

    /**
     * Método que muestra los elementos que contiene la lista
     */
    public void mostrar() {
        for (int i = 0; i < numEtiquetas; i++) {
            System.out.println(lista[i].getApertura() + ", " + lista[i].getCierre());
        }
    }

    /**
     * Método que recibe un elemento, y si es una etiqueta de apertura, devuelve su posicion
     * @param dato el String que queremos comprobar
     * @return si está en la lista devuelve su posición, sino, devuelve -1
     */
    private int posicionApertura(String dato) {
        int resultado = -1;
        int i = 0;
        while (resultado == -1 && i < numEtiquetas) {
            if (lista[i].getApertura().equals(dato))
                resultado = i;
            else i++;
        }
        return resultado;
    }

    /**
     * Método que recibe un elemento, y si es una etiqueta de cierre, devuelve su posicion
     * @param dato el String que queremos comprobar
     * @return si está en la lista devuelve su posición, sino, devuelve -1
     */
    private int posicionCierre(String dato) {
        int resultado = -1;
        int i = 0;
        while (resultado == -1 && i < numEtiquetas) {
            if (lista[i].getCierre().equals(dato))
                resultado = i;
            else i++;
        }
        return resultado;
    }

    /**
     * Método que recibe un elemento, y si es una etiqueta de cierre, devuelve verdadero
     * @param aux el String que queremos comprobar
     * @return si está en la lista devuelve true, sino, devuelve false
     */
    public boolean esCierre(String aux) {
        return posicionCierre(aux) != -1;
    }

    /**
     * Método que recibe un elemento, y si es una etiqueta de apertura, devuelve verdadero
     * @param aux el String que queremos comprobar
     * @return si está en la lista devuelve true, sino, devuelve false
     */
    public boolean esApertura(String aux) {
        return posicionApertura(aux) != -1;
    }

    /**
     * Método que recibe un elemento, y si es una etiqueta, devuelve verdadero
     * @param dato el String que queremos comprobar
     * @return si está en la lista devuelve true, sino, devuelve false
     */
    public boolean esEtiqueta(String dato) {
        return posicionApertura(dato) != -1 || posicionCierre(dato) != -1;
    }

    /**
     * Método que recibe dos String y comprueba si los dos son elementos de la misma etiqueta (uno
     * de apertura y otro de cierre)
     * @param abre String que queremos comprobar si es la etiqueta de apertura
     * @param cierra  String que queremos comprobar si es la etiqueta de cierre
     * @return true si las dos etiquetas están emparejadas, false en caso contrario
     */
    public boolean emparejados (String abre, String cierra) {
        return posicionApertura(abre) == posicionCierre(cierra);
    }
}
