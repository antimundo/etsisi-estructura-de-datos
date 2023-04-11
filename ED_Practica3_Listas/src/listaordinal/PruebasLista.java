package listaordinal;

public class PruebasLista {
    public static void main(String[] args) {
        // Introducir aquí las pruebas pedidas en la práctica
        System.out.println("# Prueba 2.2");
        ListaOrdinal listaOrdinal = new ListaOrdinal();
        Producto mesa = new Producto("Mesa escritorio", 185f, 2);
        Producto silla = new Producto("Silla oficina", 95.9f, 3);
        Producto cocina = new Producto("Mesa cocina", 125f, 1);
        Producto sillon = new Producto("Sillón reclinable", 230f, 2);
        listaOrdinal.insertar(mesa);
        listaOrdinal.insertar(silla);
        listaOrdinal.insertar(cocina);
        listaOrdinal.insertar(sillon);
        listaOrdinal.mostrar();

        System.out.println("## Eliminando las 3 sillas de oficina:");
        listaOrdinal.borrar(silla);
        listaOrdinal.mostrar();

        System.out.println("# Pruebas 3.1 y 3.2");
        Factura factura = new Factura("12345678B", "17/03/2021");
        factura.añadirProducto(mesa);
        factura.añadirProducto(silla);
        factura.añadirProducto(cocina);
        factura.añadirProducto(sillon);
        Producto nuevaSilla = new Producto("Silla oficina", 95.9f, 1);
        factura.añadirProducto(nuevaSilla);
        factura.mostrar();

        System.out.println("\n# Pruebas 3.4");
        Producto silla_oficina = new Producto("Silla oficina", 95.9f, 2);
        Producto sillon_reclinable = new Producto("Sillón reclinable", 230f, 3);
        int cantidadEliminada = factura.eliminarProducto(silla_oficina) + factura.eliminarProducto(sillon_reclinable);
        System.out.println("Nº de Productos eliminados:  " + cantidadEliminada);
        factura.mostrar();

        System.out.println("\n# Pruebas 3.5");
        ListaOrdinal lista = factura.mayoresPrecios(100f);
        System.out.println("Se han obtenido " + lista.getNumElementos() + " productos con un precio mayor a 100 euros por unidad.");
        lista.mostrar();

        System.out.println("\n# Mis tests");
    }
}
