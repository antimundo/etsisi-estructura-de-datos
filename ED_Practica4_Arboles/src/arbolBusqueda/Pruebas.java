package arbolBusqueda;

public class Pruebas {

	// ArbolBusqueda.Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		Pruebas pruebas = new Pruebas();
		pruebas.ejecutar();
	}

	private void ejecutar() {
		// Alumnos ------------------------------------------------------------
		Alumno alicia = new Alumno("Alicia Blazquez Martin", 5622);
		Alumno pedro = new Alumno("Pedro Jimenez del Pozo", 8510);
		Alumno adriana = new Alumno("Adriana Torres Pardo", 2345);
		Alumno felipe = new Alumno("Felipe Garcia Gomez", 1253);
		Alumno eduardo = new Alumno("Eduardo Parra Martin", 8765);
		Alumno diego = new Alumno("Diego Perez Gonzalez", 8135);
		Alumno mar = new Alumno("Mar Hernando Lopez", 8217);

		// ArbolBusqueda.Arbol --------------------------------------------------------------
		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
		arbol.insertar(alicia);
		arbol.insertar(pedro);
		arbol.insertar(adriana);
		arbol.insertar(felipe);
		arbol.insertar(eduardo);
		arbol.insertar(diego);
		arbol.insertar(mar);

		// ArbolBusqueda.Pruebas
		System.out.println("----------------- ArbolBusqueda.Arbol ----------------");
		System.out.println("Hay " + arbol.getNumElementos() + " alumnos:");
		arbol.mostrar();
		System.out.println("----------------------------------------");

		System.out.println();
		System.out.print("El alumno con menor clave es: ");
		this.mostrarAlumno(arbol.getMenorElemento());
		System.out.println("----------------------------------------");

		System.out.println();
		this.mostrarMenores(arbol, 5623);
		this.mostrarMenores(arbol, 8511);
		this.mostrarMenores(arbol, 2346);
		this.mostrarMenores(arbol, 1254);
		this.mostrarMenores(arbol, 8766);
		this.mostrarMenores(arbol, 8136);
		this.mostrarMenores(arbol, 8218);
		this.mostrarMenores(arbol, 1253);
		System.out.println("----------------------------------------");

		System.out.println();
		this.mostrarIntermedios(arbol, 1000, 1253);
		this.mostrarIntermedios(arbol, 1000, 2000);
		this.mostrarIntermedios(arbol, 1000, 4000);
		this.mostrarIntermedios(arbol, 1000, 8135);
		this.mostrarIntermedios(arbol, 1000, 9000);
		this.mostrarIntermedios(arbol, 2000, 2200);
		this.mostrarIntermedios(arbol, 2344, 8500);
		this.mostrarIntermedios(arbol, 3000, 9000);
		this.mostrarIntermedios(arbol, 9000, 10000);
		System.out.println("----------------------------------------");
	}

	private void mostrarAlumno(Alumno alumno) {
		if (alumno == null) {
			System.out.println("NINGUNO");
		} else {
			alumno.mostrar();
		}
	}

	private void mostrarMenores(ArbolBinarioBusqueda arbol, int clave) {
		System.out.println("Hay " + arbol.getNumMenores(clave)
				+ " alumnos con clave menor que " + clave);
	}

	private void mostrarIntermedios(ArbolBinarioBusqueda arbol, int claveMaximo, int claveMayor) {
		System.out.println("Hay " + arbol.getNumIntermedios(claveMaximo, claveMayor)
				+ " alumnos con clave mayor que " + claveMaximo + " y menor que " + claveMayor);
	}
}
