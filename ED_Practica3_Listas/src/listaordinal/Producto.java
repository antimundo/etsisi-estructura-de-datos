package listaordinal;

public class Producto {
    private String descripcion;
    private float precio;
    private int unidades;

    public Producto(String descripcion, float precio, int unidades) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
    }

    public Producto(String descripcion, float precio) {
        this(descripcion, precio, 1);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void mostrar() {
        System.out.println("  " + descripcion + " (" + unidades + " unidades) a " +
                precio + " € c/u. Importe: " + precio* unidades + " €");
    }

    public boolean equals(Producto producto) {
        return descripcion.equals(producto.descripcion) &&
                precio == producto.precio;
    }






    public boolean equals(Object obj) {
        return this.equals((Producto)obj);
    }
}
