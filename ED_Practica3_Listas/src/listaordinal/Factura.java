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
        // Completar
    }

    public void mostrar() {
        // Completar
    }

    public float importeTotal() {
        // Completar
        return 0.0f; // Línea puesta para evitar error. Eliminarla al codificar el método
    }

    public int eliminarProducto(Producto producto) {
        // Completar
        return 0; // Línea puesta para evitar error. Eliminarla al codificar el método
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        // Completar
        return null; // Línea puesta para evitar error. Eliminarla al codificar el método
    }
}
