package listaordinal;

import listaordinal.Producto;

import java.util.Iterator;
import java.util.LinkedList;

public class FacturaBib {
    private String dni;
    private String fecha;
    private LinkedList<Producto> listaProductos;
    private boolean cobrada;

    public FacturaBib(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new LinkedList<Producto>();
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
        Iterator<Producto> iterador = listaProductos.iterator();
        boolean repetido = false;

        while (iterador.hasNext() && !repetido) {
            Producto auxiliar = iterador.next();
            if (auxiliar.equals(producto)) {
                auxiliar.setUnidades(producto.getUnidades() + auxiliar.getUnidades());
                repetido = true;
            }
        }
        if (!repetido) {
            listaProductos.add(producto);
        }
    }

    public void mostrar() {
        Iterator<Producto> iterador = listaProductos.iterator();

        System.out.println("## FACTURA de: " + dni + "\tFecha: " + fecha);
        while (iterador.hasNext()) {
            Producto aux = iterador.next();
            aux.mostrar();
        }
        System.out.println("Importe Total: " + importeTotal());
    }

    public float importeTotal() {
        Iterator<Producto> iterador = listaProductos.iterator();

        float total = 0f;
        while (iterador.hasNext()) {
            Producto aux = iterador.next();
            total += aux.getPrecio() * aux.getUnidades();
        }
        return total;
    }

    public int eliminarProducto(Producto producto) {
        Iterator<Producto> iterador = listaProductos.iterator();
        boolean encontrado = false;
        int unidades = 0;

        while (!encontrado && iterador.hasNext()) {
            Producto auxiliar = iterador.next();
            encontrado = auxiliar.equals(producto);

            if (encontrado) {
                if (producto.getUnidades() >= auxiliar.getUnidades()) {
                    unidades = auxiliar.getUnidades();
                    listaProductos.remove(auxiliar);
                } else {
                    unidades = auxiliar.getUnidades() - producto.getUnidades();
                    auxiliar.setUnidades(unidades);
                }
            }
        }
        return unidades;
    }

    public LinkedList<Producto> mayoresPrecios(float precio) {
        LinkedList<Producto> lista = new LinkedList<Producto>();
        Iterator<Producto> iterador = listaProductos.iterator();

        while (iterador.hasNext()) {
            Producto producto = iterador.next();
            if (producto.getPrecio() > precio) {
                lista.add(producto);
            }
        }
        return lista;
    }
}
