/**
 * Clase UtilizacionPila, para desarrollar los ejercicios propuestos en el
 * apartado 2
 *
 * @author
 * @version
 */
public class UtilizacionPila {

    /**
     * TO-Do 1: Método que recibe un texto y una lista de etiquetas. Comprueba
     * si todas las etiquetas del texto están balanceadas (cada etiqueta de
     * apertura se corresponde con una de cierre)
     *
     * @param lista contiene las etiquetas que queremos analizar.
     * @param texto que contiene el contenido de una página html
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarTexto (ListaEtiquetas lista, String texto) {
        Pila miPila = new Pila();
        String[] elementos = texto.split(" ");
        boolean control = true;
        for (int i = 0; i < elementos.length && control; i++){
            if (lista.esApertura(elementos[i])){
                miPila.apilar(elementos[i]);
            }
            else if (lista.esCierre(elementos[i])){
                String etiqueta = miPila.desapilar();
                if(!lista.emparejados(etiqueta, elementos[i])){
                    control = false;
                    System.out.println("En la pila quedan elementos:");
                    mostrarInverso(miPila);
                }
            }
        }
        return control;
    }

    /**
     * Método que muestra el contenido de la pila invertido (el fondo arriba y la cima abajo)
     * @param pila la pila que deseamos mostrar
     */
    public void mostrarInverso(Pila pila) {
        if (!pila.vacia()){
            String thisDato = pila.desapilar();
            mostrarInverso(pila);
            System.out.println(thisDato);
            pila.apilar(thisDato);
        }
    }
}

