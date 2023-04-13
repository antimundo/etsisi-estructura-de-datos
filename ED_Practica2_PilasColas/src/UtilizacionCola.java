/**
 * Clase UtilizacionCola, para desarrollar los ejercicios propuestos en el
 * apartado 4
 *
 * @author
 */
public class UtilizacionCola {

    /**
     * TO-DO 1: Método que recibe una lista de etiquetas html y un String
     * conteniendo una página html.
     * Genera una cola que contiene las etiquetas de la lista contenidas en el texto
     *
     * @param lista lista que contiene las etiquetas que queremos comprobar
     * @param texto la página que vamos a analizar
     * @return la cola que contiene las etiquetas de la lista contenidas en el texto
     */
    // <a> <b></b> <c></c> </a>
    public Cola leerTexto(ListaEtiquetas lista, String texto) {
        Cola cola = new Cola();
        int contador = 0;
        String etiqueta = null;
        String tipoEtiqueta = "";
        boolean tipoEtiquetaVerificado = false;
        String interiorEtiqueta = "";
        boolean cerrandoEtiqueta = false;
        String tipoEtiquetaCierre = "";
        boolean contarInterior = false;
        for (int i = 0; i < texto.length(); i++) {
            if (etiqueta == null && texto.charAt(i) == '<') {
                etiqueta = "<";
            } else if (etiqueta != null) {
                etiqueta += texto.charAt(i);
                if (contarInterior) {
                    interiorEtiqueta += texto.charAt(i);
                }
                if (!tipoEtiquetaVerificado) {
                    if (texto.charAt(i) == '>') {
                        contarInterior = true;
                        tipoEtiquetaVerificado = true;
                    } else {
                        tipoEtiqueta += texto.charAt(i);
                    }
                }
                if (texto.charAt(i) == '<' && texto.charAt(i + 1) == '/') {
                    contarInterior = false;
                    cerrandoEtiqueta = true;
                }
                if (cerrandoEtiqueta) {
                    if (texto.charAt(i) == '>') {
                        if (tipoEtiquetaCierre.equals(tipoEtiqueta)) {
                            etiqueta += texto.charAt(i + 1);
                            interiorEtiqueta = interiorEtiqueta.replaceAll(".$", "");
                            Cola subCola = leerTexto(lista, interiorEtiqueta);
                            while (!subCola.vacia()) {
                                cola.encolar(subCola.desencolar());
                            }
                            if (lista.esEtiqueta("<" + tipoEtiqueta + ">")) {
                                //cola.encolar(etiqueta);
                                cola.encolar("<" + tipoEtiqueta + ">" + "<" + tipoEtiqueta + "/>");
                            }
                            etiqueta = null;
                            tipoEtiqueta = "";
                            tipoEtiquetaVerificado = false;
                            interiorEtiqueta = "";
                        } else {
                            contarInterior = true;
                            interiorEtiqueta += "/" + tipoEtiquetaCierre + ">";
                        }
                        cerrandoEtiqueta = false;
                        tipoEtiquetaCierre = "";
                    } else if (texto.charAt(i) != '<' && texto.charAt(i) != '/') {
                        tipoEtiquetaCierre += texto.charAt(i);
                    }
                }
            }
        }
        return cola;
    }

    /**
     * Método que recibe una cola y una lista de etiquetas. Comprueba si todas las etiquetas
     * de la cola están balanceadas (cada etiqueta de apertura se corresponde con una de cierre)
     * @param cola  que contiene las etiquetas extraídas de una página html
     * @param lista contiene las etiquetas que queremos analizar.
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarHtml(Cola cola, ListaEtiquetas lista) {
        Pila miPila = new Pila();
        boolean control = true;
        int numElementos= cola.getNumElementos();
        int index = 0;
        while(index < numElementos && control){
            String etiqueta = cola.desencolar();
            cola.encolar(etiqueta);
            if (lista.esApertura(etiqueta)){
                miPila.apilar(etiqueta);
            }
            else if (lista.esCierre(etiqueta)){
                String etiqueta2 = miPila.desapilar();
                if(!lista.emparejados(etiqueta2, etiqueta)){
                    control = false;
                }
            }
            index++;
        }
        if (!miPila.vacia()){
            miPila.mostrar();
        }
        return control;
    }
}
