package arbolNario;

public class Pruebas {
	
	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		Pruebas pruebas = new Pruebas();
		pruebas.ejecutar();
	}

	private void ejecutar() {
		// Hojas
		ArbolNario arbol3 = new ArbolNario(3);
		ArbolNario arbol4 = new ArbolNario(4);
		ArbolNario arbol6 = new ArbolNario(6);
		ArbolNario arbol7 = new ArbolNario(7);
		ArbolNario arbol9 = new ArbolNario(9);
		ArbolNario arbol10 = new ArbolNario(10);
		ArbolNario arbol11 = new ArbolNario(11);

		// Subarbol 2
		ArbolNario arbol2 = new ArbolNario(2);
		arbol2.insertar(arbol3);
		arbol2.insertar(arbol4);

		// Subarbol 5
		ArbolNario arbol5 = new ArbolNario(5);
		arbol5.insertar(arbol6);

		// Subarbol 8
		ArbolNario arbol8 = new ArbolNario(8);
		arbol8.insertar(arbol9);
		arbol8.insertar(arbol10);
		arbol8.insertar(arbol11);

		// Arbol
		ArbolNario arbol1 = new ArbolNario(1);
		arbol1.insertar(arbol2);
		arbol1.insertar(arbol5);
		arbol1.insertar(arbol7);
		arbol1.insertar(arbol8);

		// Pruebas
		arbol1.mostrarProfundidadRecursivo();
		arbol1.mostrarProfundidadIterativo();
		arbol1.mostrarAmplitud();
	}
}
