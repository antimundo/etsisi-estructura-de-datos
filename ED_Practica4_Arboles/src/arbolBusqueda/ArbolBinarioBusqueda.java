package arbolBusqueda;

public class ArbolBinarioBusqueda {

    private NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    // Muestra los elementos del arbol binario en orden central ---------------
    public void mostrar() {
        this.mostrar(raiz, "  ");
    }

    private void mostrar(NodoArbol nodo, String espacios) {
        if (nodo != null) {
            this.mostrar(nodo.getIzquierdo(), espacios + "    ");
            System.out.print(espacios);
            nodo.getDato().mostrar();
            this.mostrar(nodo.getDerecho(), espacios + "    ");
        }
    }

    // Inserta un elemento con una cierta clave -------------------------------
    public void insertar(Alumno dato) {
        raiz = this.insertarRec(raiz, dato);
    }

    private NodoArbol insertarRec(NodoArbol nodo, Alumno dato) {
        if (nodo == null) {     // Crear nuevo nodo
            nodo = new NodoArbol(dato);
        } else if (dato.getMatricula() < nodo.getDato().getMatricula()) {    // Subárbol izquierdo
            NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
            nodo.setIzquierdo(nuevoIzq);
        } else if (dato.getMatricula() > nodo.getDato().getMatricula()) {    // Subárbol derecho
            NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
            nodo.setDerecho(nuevoDer);
        } else {      // Clave repetida
            System.out.println("Error. El alumno con matrícula " + dato.getMatricula() + " ya existe");
        }
        return nodo;    // Devolver la nueva raíz del subárbol
    }

    int test(NodoArbol nodo){
        int resultado;
        if (nodo == null){
            resultado = 0;
        }
        else{
            resultado = 1;
        }
        return resultado;
    }

    // ------------------------------------------------------------------------
    // TODO 3.2: Devuelve el numero de nodos del arbol de forma RECURSIVA
    public int getNumElementos() {
        return getNumElementos(raiz);
    }

    private int getNumElementos(NodoArbol arbol) {
        if (arbol == null) {
            return 0;
        } else {
            int numElementos = 1;
            numElementos += getNumElementos(arbol.getIzquierdo());
            numElementos += getNumElementos(arbol.getDerecho());
            return numElementos;
        }
    }


    // ------------------------------------------------------------------------
    // TODO 3.3: Devuelve el numero de nodos del arbol con clave
    // menor a una clave dada de forma RECURSIVA
    public int getNumMenores(int clave) {
        return getNumMenores(clave, raiz);
    }

    private int getNumMenores(int clave, NodoArbol arbol) {
        if (arbol == null) {
            return 0;
        } else {
            int contador = 0;
            Alumno alumno = arbol.getDato();
            if (clave > alumno.getMatricula()) {
                contador++;
            }
            contador += getNumMenores(clave, arbol.getIzquierdo());
            contador += getNumMenores(clave, arbol.getDerecho());
            return contador;
        }
    }


    // ------------------------------------------------------------------------
    // TODO 3.4: Devuelve el elemento con la menor clave de forma RECURSIVA
    public Alumno getMenorElemento() {
        return getMenorElemento(raiz);
    }

    private Alumno getMenorElemento(NodoArbol arbol) {
        if (arbol == null) {
            return null;
        }
        if (arbol.getIzquierdo() == null) {
            return arbol.getDato();
        }
        Alumno minAlumno = getMenorElemento(arbol.getIzquierdo());
        if (minAlumno != null && minAlumno.getMatricula() < arbol.getDato().getMatricula()) {
            return minAlumno;
        }
        return arbol.getDato();
    }


    // ------------------------------------------------------------------------
    // TODO 3.5: Devuelve el número de nodos del árbol con clave mayor que
    // claveMinimo y menor que claveMaximo
    public int getNumIntermedios(int claveMinimo, int claveMaximo) {
        return getNumIntermedios(claveMinimo, claveMaximo, raiz);
    }

    private int getNumIntermedios(int claveMinimo, int claveMaximo, NodoArbol arbol) {
        if (arbol == null) {
            return 0;
        } else {
            int contador = 0;
            if (arbol.getDato() != null && arbol.getDato().getMatricula() > claveMinimo && arbol.getDato().getMatricula() < claveMaximo) {
                contador++;
            }
            contador += getNumIntermedios(claveMinimo, claveMaximo, arbol.getIzquierdo());
            contador += getNumIntermedios(claveMinimo, claveMaximo, arbol.getDerecho());
            return contador;
        }
    }

}
