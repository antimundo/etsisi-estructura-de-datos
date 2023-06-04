
public class AmigosETSISI {
    //MOMBRE  Y GRUPO DEL ALUMNO
    private GrafoMA miREd;
    private Persona[] contactos;


    public AmigosETSISI(int n, Persona[] contactos) { //construye una matriz de nxn sin aristas
        miREd = new GrafoMA(n, false);
        this.contactos = contactos;
    }

    public int getNumPersonas() {
        return miREd.getNumVertices();
    }


    // MÉTODOS PARA INSERTAR Y ELIMINAR ARISTAS

    // ------------------------------------
    // método que inserta una relación de amistad directa (una arista en el grafo)
    public void insertaRelacion(int o, int d) {
        miREd.insertarArista(o, d);
    }

    // método que elimina una relación de amistad directa (una arista en el grafo)
    public void eliminaRelacion(int o, int d) {
        miREd.eliminarArista(o, d);
    }

    // método que indica si existe una relación de amistad directa (una arista en el grafo)
    public boolean existeRelacion(int o, int d) {
        return miREd.existeArista(o, d);
    }

    //Metodo que compara dos cadenas que representan dos nombres ignorando mayusculas y minusculas
    private boolean nombresIguales(String cad1, String cad2) {
        return (cad1.equalsIgnoreCase(cad2));
    }


    // encuentra la posición asociado a un nombre de persona en la tablade contactos que
    // ademas se corresponde con el vertice que le representa en el grafo

    public int devuelvePosNombre(String nombre) {
        int i = 0;
        boolean encontrado = false;
        while (i < contactos.length && !encontrado) {
            encontrado = nombresIguales(nombre, contactos[i].getNombre());
            if (!encontrado) i++;
        }
        // if (!miREd.verticeEnRango(i)) i=-1;//si ha salido por i= contactos.length no esta el nombre en la tabla
        if (!encontrado) i = -1;
        return i;
    }

    // devuelve una copia de un array
    private boolean[] copia(boolean[] v1) {
        boolean[] resul = new boolean[v1.length];
        for (int i = 0; i < v1.length; i++)
            resul[i] = v1[i];
        return resul;
    }
    //inicializa el array de vistados a false

    private boolean[] inicia_Visitados(boolean[] v1) {
        boolean[] resul = new boolean[v1.length];
        for (int i = 0; i < v1.length; i++)
            resul[i] = false;
        return resul;
    }


    // Imprime la Matriz del relaciones( Matriz de adyacencia del grafo) por consola
    public void imprimirRelaciones() {
        System.out.println("Contenido de la matriz: ");
        System.out.print("  ");
        for (int i = 0; i < miREd.getNumVertices(); i++) {
            if (i < 10) System.out.print(" " + i + " ");
            else System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < miREd.getNumVertices(); i++) {
            if (i < 10) System.out.print(" " + i);
            else System.out.print(i);
            for (int j = 0; j < miREd.getNumVertices(); j++) {
                if (miREd.existeArista(i, j)) System.out.print(" S ");
                else System.out.print(" N ");
            }
            System.out.println();
        }
    }

    //Imprime la información de la red y la matriz de Relaciones por consola
    public void mostrarRed() {
        System.out.println("Existen " + miREd.getNumVertices() + " contactos: \n");
        for (int i = 0; i < miREd.getNumVertices(); i++)
            System.out.println(i + ": " + contactos[i].getNombre());
        imprimirRelaciones();
        System.out.println();
    }

// ------------------------------------

    // MÉTODOS A COMPLETAR

    // ------------------------------------


    // TODO Apartado 2.2 Primer método
    public int mostrarGrupos() {
        int resul = 0;
        boolean[] visitados = new boolean[miREd.getNumVertices()];
        visitados = inicia_Visitados(visitados);
        for (int i = 0; i < miREd.getNumVertices(); i++){
            if (!visitados[i]){
                marcarConexionesComoVisitadas(i, visitados);
                resul++;
                System.out.println();
            }
        }
        return resul;
    }

    void marcarConexionesComoVisitadas(int vertice, boolean[] visitados){
        visitados[vertice] = true;
        System.out.print(contactos[vertice].getNombre() + ", ");

        for (int i = 0; i < miREd.getNumVertices(); i++){
            if (!visitados[i] && miREd.existeArista(vertice, i)){
                marcarConexionesComoVisitadas(i, visitados);
            }
        }
    }

    // TODO Apartado 2.2 Segundo método
    public void mostrarAmigosIndirectos(String nombre) {
        if (devuelvePosNombre(nombre) < 0){
            System.out.println(nombre + " no está en la lista de contactos");
        }
        else {
            boolean[] visitados = new boolean[miREd.getNumVertices()];
            int verticeOriginal = devuelvePosNombre(nombre);
            System.out.print("Todos los amigos (indirectos y directos) de " + nombre + "(" + verticeOriginal + ") son: ");
            visitados = inicia_Visitados(visitados);
            marcarConexionesComoVisitadas(verticeOriginal, visitados);
            System.out.println("\nLos amigos (directos) de " + nombre + "(" + verticeOriginal + ") son:");
            for (int i = 0; i < miREd.getNumVertices(); i++){
                if (visitados[i] && !miREd.existeArista(verticeOriginal, i) && i != verticeOriginal){
                    System.out.println(i + ": " + contactos[i].getNombre());
                }
            }
        }
    }

    // TODO Apartado 2.2 Tercer método
    public boolean noSonAmigos(Persona p, Persona p1) {
        boolean sonAmigos = false;
        if (devuelvePosNombre(p.getNombre()) < 0 || devuelvePosNombre(p1.getNombre()) < 0)
            sonAmigos = false;
        else{
            boolean[] visitados = new boolean[miREd.getNumVertices()];
            visitados = inicia_Visitados(visitados);
            marcarConexionesComoVisitadas(devuelvePosNombre(p.getNombre()), visitados);
            sonAmigos = !visitados[devuelvePosNombre(p1.getNombre())];
        }
        return sonAmigos;
    }

    // TODO Apartado 2.2 Cuarto método
    public void mostrarMiembrosSiAmigos(Persona p, Persona p1) {
        if (devuelvePosNombre(p.getNombre()) < 0 || devuelvePosNombre(p1.getNombre()) < 0){
            System.out.println("Alguna de las dos personas no están en la lista de contactos");
        }
        else {
            boolean[] visitados = new boolean[miREd.getNumVertices()];
            visitados = inicia_Visitados(visitados);
            int indicePersona = devuelvePosNombre(p.getNombre());
            marcarConexionesComoVisitadas(indicePersona, visitados);
            if (visitados[devuelvePosNombre(p1.getNombre())]){
                System.out.println("Lista de amigos de: " + p.getNombre() + " y " + p1.getNombre());
                for (int i = 0; i < miREd.getNumVertices(); i++){
                    if (visitados[i]){
                        System.out.println(i + ": " + contactos[i].getNombre() + " está en la lista de amigos");
                    }
                }
            } else {
                System.out.println("\n" + p.getNombre() + " no está entre los amigos de " + p1.getNombre());
            }
        }
    }

}
	  




