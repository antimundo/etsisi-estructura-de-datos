package listaordinal;

public class Factura {
    private String dni;
    private String fecha;
    private ListaOrdinal listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new ListaOrdinal();
        cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        cobrada = true;
    }

    public void añadirProducto(Producto producto) {
        Iterador iterador = listaProductos.getIterador();
        boolean repetido = false;

        while (!repetido && iterador.hasNext()) {
            Producto auxiliar = iterador.next();
            if (auxiliar.equals(producto)) {
                auxiliar.setUnidades(auxiliar.getUnidades() + producto.getUnidades());
                repetido = true;
            }
        }
        if (!repetido) {
            listaProductos.insertar(producto);
        }
    }

    public void mostrar() {
        Iterador iterador = listaProductos.getIterador();

        System.out.println("## FACTURA. Dni: " + dni + "\tFecha: " + fecha);
        while (iterador.hasNext()) {
            Producto auxiliar = iterador.next();
            auxiliar.mostrar();
        }
        System.out.println("Importe Total: " + importeTotal());
    }

    public float importeTotal() {
        Iterador iterador = listaProductos.getIterador();
        float total = 0;

        while (iterador.hasNext()) {
            Producto auxiliar = iterador.next();
            total += auxiliar.getPrecio() * auxiliar.getUnidades();
        }

        return total;
    }

    public int eliminarProducto(Producto producto) {
        Iterador iterador = listaProductos.getIterador();
        boolean encontrado = false;
        int unidades = 0;

        while (!encontrado && iterador.hasNext()) {
            Producto auxiliar = iterador.next();
            encontrado = auxiliar.equals(producto);

            if (encontrado) {
                if (producto.getUnidades() >= auxiliar.getUnidades()) {
                    unidades = auxiliar.getUnidades();
                    listaProductos.borrar(auxiliar);
                } else {
                    unidades = (auxiliar.getUnidades() - producto.getUnidades());
                    auxiliar.setUnidades(auxiliar.getUnidades() - producto.getUnidades());
                }
            }
        }
        return unidades;
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        ListaOrdinal lista = new ListaOrdinal();
        Iterador iterador = listaProductos.getIterador();

        while (iterador.hasNext()) {
            Producto auxiliar = iterador.next();
            if (auxiliar.getPrecio() > precio) {
                lista.insertar(auxiliar);
            }
        }
        return lista;
    }
}
