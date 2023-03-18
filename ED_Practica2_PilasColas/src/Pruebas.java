/**
 * Clase Pruebas, contiene los métodos para probar los ejemplos de manejo de pilas, colas y Stack
 *
 * Esta clase se entrega completamente desarrollada, no se tiene que modificar
 *
 * @author Pilar Martinez Garcia
 * @version 1.0
 */
public class Pruebas {

    /**
     * el atributo lista contiene una lista con las posibles etiquetas html que se van a poder comprobar
     * en el texto
     */
    private ListaEtiquetas lista;

    /**
     * Constructor de la clase
     * Prepara la lista de etiquetas que vamos a poder utilizar en los distintos métodos
     */
    public Pruebas () {
        String [] datos = {"html", "body","title","p", "b", "i", "ul","ol","li"};
        lista = new ListaEtiquetas(20,datos);
    }

    /**
     * Método que contiene las pruebas que vamos a realizar de los métodos a desarrollar en la
     * clase UtilizacionPilas
     */
    public void pruebasPila () {
        UtilizacionPila pruebasPila = new UtilizacionPila();
        String linea  = ejemplo1();
        System.out.println("\nEjemplo1:");
        boolean resultado = pruebasPila.comprobarTexto(lista, linea);
        System.out.println("Resultado: "+resultado);

        linea = ejemplo2();
        System.out.println("\nEjemplo2:");
        resultado = pruebasPila.comprobarTexto(lista, linea);
        System.out.println("Resultado: "+resultado);

        linea = ejemplo3();
        System.out.println("\nEjemplo3:");
        resultado = pruebasPila.comprobarTexto(lista, linea);
        System.out.println("Resultado: "+resultado);

        linea ="";
        System.out.println("\nCadena vacia:");
        resultado = pruebasPila.comprobarTexto(lista, linea);
        System.out.println("Resultado: "+resultado);
    }

    /**
     * Método que contiene las pruebas que vamos a realizar de los métodos a desarrollar en la
     * clase UtilizacionStack
     */
    public void pruebasStack () {
        UtilizacionStack pruebas = new UtilizacionStack();
        String linea  = ejemplo1();
        System.out.println("\nEjemplo1 con Stack:");
        boolean resultado = pruebas.comprobarLineaStack(lista, linea);
        System.out.println("Resultado: "+resultado);

        linea  = ejemplo2();
        System.out.println("\nEjemplo2 con Stack:");
        resultado = pruebas.comprobarLineaStack(lista, linea);
        System.out.println("Resultado: "+resultado);

        linea ="";
        System.out.println("\nCadena vacia:");
        resultado = pruebas.comprobarLineaStack(lista, linea);
        System.out.println("Resultado: "+resultado);
    }
    /**
     * Método que contiene las pruebas que vamos a realizar de los métodos a desarrollar en la
     * clase UtilizacionColas, que manejarán una cola
     */

    public void pruebasCola () {
        UtilizacionCola pruebasCola = new UtilizacionCola();
        String linea  = ejemplo1();
        System.out.println("\nGuardamos las etiquetas del ejemplo1 en una Cola:");
        Cola cola = pruebasCola.leerTexto(lista, linea);
        cola.mostrar();

        linea ="";
        System.out.println("\nCadena vacia:");
        cola = pruebasCola.leerTexto(lista, linea);
        cola.mostrar();
    }

    /**
     * Método que contiene las pruebas que vamos a realizar de los métodos a desarrollar en la
     * clase UtilizacionColas, que manejarán tanto una pila como una cola
     */
    public void pruebasCombinadas () {
        UtilizacionCola pruebasCola = new UtilizacionCola();

        String linea  = ejemplo1();
        System.out.println("\nEjemplo1 con Pila y Cola:");
        Cola cola = pruebasCola.leerTexto(lista, linea);
        cola.mostrar();
        boolean resultado = pruebasCola.comprobarHtml(cola, lista);
        System.out.println("Resultado: "+resultado);
        cola.mostrar();

        System.out.println("\nEjemplo2 con Pila y Cola:");
        linea = ejemplo2();
        cola = pruebasCola.leerTexto(lista, linea);
        cola.mostrar();
        resultado = pruebasCola.comprobarHtml(cola, lista);
        System.out.println("Resultado: "+resultado);
        cola.mostrar();

        linea ="";
        System.out.println("\nCadena vacia:");
        cola = pruebasCola.leerTexto(lista, linea);
        cola.mostrar();
        resultado = pruebasCola.comprobarHtml(cola, lista);
        System.out.println("Resultado: "+resultado);
        cola.mostrar();
    }
    /**
     * Método que llama a los anteriores (pruebasPila, pruebas Stack, pruebasCola
     * y pruebasCombinadas, para realizar las distintas pruebas
     */

    public void probarOpciones () {
        pruebasPila();
        pruebasStack();
        pruebasCola();
        pruebasCombinadas();
    }


    public String ejemplo1 () {
        return " <html> <title> Prueba de texto en html </title> \n"+
                " <body> <p> Esto es el cuerpo </p> \n" +
                " <p> Probamos la lista no ordenada: </p> <p> <ul> \n" +
                "    <li> un elemento </li>  \n" +
                "    <li> otro elemento </li>  \n" +
                "    <li> elemento final </li>  \n" +
                " </ul> </p>  \n" +
                " <p> Ahora la ordenada: </p> <p> <ol> \n" +
                "    <li> Primer elemento </li> \n" +
                "    <li> Segundo elemento </li> \n" +
                "    <li> Tercero </li> \n" +
                " </ol> </p> \n" +
                " <p> Y el texto en <b> negrita </b> y <i> cursiva </i>  </p> \n" +
                " <p> Fin del texto </p>  </body> </html> ";
    }
    public String ejemplo2 () {
        return " <title> Prueba de texto con fallos en html </title> \n"+
                " <body> <p> Esto es el cuerpo </p> \n" +
                " <p> Este texto tiene fallos: </p> <p> <ul> \n" +
                "    <li> un elemento </li>  \n" +
                "    <li> otro elemento </li>  \n" +
                "    <li> elemento final </li>  \n" +
                " <p> Ahora la ordenada: </p> <p> <ol> \n" +
                "    <li> Primer elemento </li> \n" +
                "    <li> Segundo elemento </li> \n" +
                "    <li> Tercero </li> \n" +
                " </ol> </p> \n" +
                " <p> Y el texto en <b> negrita </b> y <i> cursiva </i>  </p>\n " +
                " <p> Fin del texto </p>  </body> ";
    }
    public String ejemplo3 () {
        return " <html> <title> Prueba de texto en html </title> \n"+
                " <body> <p> Esto es el cuerpo </p> \n" +
                " <p> Probamos la lista no ordenada: </p> <p> <ul> \n" +
                "    <li> un elemento con otra lista ordenada dentro <ol> \n" +
                "    <li> Primer elemento </li> \n" +
                "    <li> Segundo elemento </li> \n" +
                "    <li> Tercero </li> \n" +
                " </ol> </li>  \n" +
                "    <li> otro elemento </li>  \n" +
                "    <li> elemento final </li>  \n" +
                " </ul> </p>  \n" +
                " <p> Y el texto en <b> negrita </b> y <i> cursiva </i>  </p> \n" +
                " <p> Fin del texto </p>  </body> </html> ";
    }

}
