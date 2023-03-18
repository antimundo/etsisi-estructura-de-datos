import java.util.Stack;

/**
 * Clase UtilizacionStack, para desarrollar los ejercicios propuestos en el apartado 3
 * @author
 * @version
 */
public class UtilizacionStack {

    /**
     * Método que recibe un texto y una lista de etiquetas. Comprueba si todas las etiquetas
     * del texto están balanceadas (cada etiqueta de apertura se corresponde con una de cierre)
     *
     * @param lista contiene las etiquetas que queremos analizar.
     * @param texto que contiene el contenido de una página html
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarLineaStack (ListaEtiquetas lista, String texto) {
        Stack<String> miStack = new Stack<String>();
        String[] elementos = texto.split(" ");
        boolean control = true;
        for (int i = 0; i < elementos.length && control; i++){
            if (lista.esApertura(elementos[i])){
                miStack.push(elementos[i]);
            }
            else if (lista.esCierre(elementos[i])){
                String etiqueta = miStack.pop();
                if(!lista.emparejados(etiqueta, elementos[i])){
                    control = false;
                    System.out.println("En la pila quedan elementos:");
                    mostrarInverso(miStack);
                }
            }
        }
        return control;
    }
    /**
     * Método que muestra el contenido de la pila
     * @param pila la pila que deseamos mostrar
     */
    public void mostrar (Stack <String> pila)  {
        if (!pila.empty()){
            String thisDato = pila.pop();
            System.out.println(thisDato);
            mostrar(pila);
            pila.push(thisDato);
        }
    }
    /**
     * Método que muestra el contenido de la pila invertido (el fondo arriba y la cima abajo)
     * @param pila la pila que deseamos mostrar
     */
    public void mostrarInverso (Stack <String> pila) {
        if (!pila.empty()){
            String thisDato = pila.pop();
            mostrarInverso(pila);
            System.out.println(thisDato);
            pila.push(thisDato);
        }
    }
}
