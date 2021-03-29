import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class ClasePrincipal {

		public static void main(String[] args) {
			Random rand = new Random(); // Clase que genera numeros aleatorios
			int tam = obtenerEntero("Introduce el tamaño del array:");// metodo
																		// estatico
																		// que lee
																		// un entero

			// crear e iniciar el arraylist
			ArrayList numeros = new ArrayList<>();
			// generar numeros aleatorios en arraylist entre 1 y 100
			for (int i = 0; i < tam; i++) {
				numeros.add(rand.nextInt(100) + 1);
			}
			// obtener el indice del elemento mas pequeño
			int indiceMenor = obtenerMenorArrList(numeros);
			// mostrar arraylist y su valor menor
			System.out.println(numeros + " y el menor es: " + numeros.get(indiceMenor));
			// ordenar el arrayList mediante un metodo estatico
			ArrayList numerosOrdenado = ordenarNumerosArrList(numeros);
			// mostar el arraylist ordenado
			System.out.println("Ordenado: " + numerosOrdenado);
			// ordenar el arraylist mediante el metodo de la burbuja
			numerosOrdenado = ordenarBurbujaArrayList(numeros);
			// mostrar el arraylist ordenado con el metodo de la burbuja
			System.out.println(numerosOrdenado);
			System.out.println();

			// se define un array vacio.
			int numeros2[];
			// generar numeros aleatorios en array mediante un metodo
			numeros2 = generarAleatorios(tam);
			// obtener el indice del elemento mas pequeño
			indiceMenor = obtenerMenorArray(numeros2);
			// mostrar array y su valor menor
			System.out.print("[");
			for (int i = 0; i < tam - 1; i++) {
				System.out.print(numeros2[i] + ", ");
			}
			System.out.print(numeros2[tam - 1] + "]");
			System.out.println(" y el menor es: " + numeros2[indiceMenor]);
			// ordenar el array mediante un metodo estatico
			int numeros2Ordenado[] = ordenarNumerosArray(numeros2);

			// mostar el array ordenado
			System.out.print("[");
			for (int i = 0; i < tam - 1; i++) {
				System.out.print(numeros2Ordenado[i] + ", ");
			}
			System.out.println(numeros2Ordenado[tam - 1] + "]");

			// ordenar el array mediante el metodo de la burbuja
			numeros2Ordenado = ordenarBurbujaArray(numeros2);
			// mostrar el arraylist ordenado con el metodo de la burbuja
			System.out.print("[");
			for (int i = 0; i < tam - 1; i++) {
				System.out.print(numeros2Ordenado[i] + ", ");
			}
			System.out.print(numeros2Ordenado[tam - 1] + "]");
			System.out.println();

		}

		private static int[] ordenarBurbujaArray(int[] numeros2) {
			int numerosCopia[] = numeros2.clone();
			int aux;
			boolean hayCambio = true;
			while (hayCambio) {
				hayCambio = false;
				for (int i = 0; i < numerosCopia.length - 1; i++) {
					if (numerosCopia[i] > numerosCopia[i + 1]) {
						aux = numerosCopia[i];
						numerosCopia[i] = numerosCopia[i + 1];
						numerosCopia[i + 1] = aux;
						hayCambio = true;
					}
				}
				System.out.println("VueltaArray");
			}
			return numerosCopia;
		}

		private static ArrayList ordenarBurbujaArrayList(ArrayList numeros) {
			ArrayList numerosCopia = (ArrayList) numeros.clone();
			Integer aux;
			boolean hayCambio = true;
			while (hayCambio) {
				hayCambio = false;
				for (int i = 0; i<numerosCopia.size() - 1; i++) {
					if (numerosCopia.get(i)>numerosCopia.get(i + 1)){
						aux=numerosCopia.get(i);
						numerosCopia.set(i, numerosCopia.get(i + 1));
						numerosCopia.set(i + 1, aux);
						hayCambio = true;
					}
				}
				System.out.println("Vuelta");
			}
			return numerosCopia;
		}

		private static int[] ordenarNumerosArray(int[] numeros2) {
			int[] numerosCopia = numeros2.clone();

			int[] retorno = new int[numeros2.length];
			int posMenor;
			for (int i = 0; i < numerosCopia.length; i++) {
				posMenor = obtenerMenorArray(numerosCopia);
				retorno[i] = numerosCopia[posMenor];
				numerosCopia[posMenor] = 1000;
			}

			return retorno;
		}

		private static ArrayList ordenarNumerosArrList(ArrayList numeros) {
			ArrayList numerosCopia = (ArrayList) numeros.clone();
			ArrayList retorno = new ArrayList<>();
			int posMenor;
			while (numerosCopia.size() > 0) {
				posMenor = obtenerMenorArrList(numerosCopia);
				retorno.add(numerosCopia.get(posMenor));
				numerosCopia.remove(numerosCopia.get(posMenor));
			}

			return retorno;
		}

		private static int obtenerMenorArray(int[] numeros) {
			int menor = numeros[0];
			int posMenor = 0;
			for (int i = 1; i < numeros.length; i++) {
				if (numeros[i] < menor) {
					menor = numeros[i];
					posMenor = i;
				}
			}
			return posMenor;
		}

		private static int obtenerMenorArrList(ArrayList numeros) {
			int menor = numeros.get(0);
			int posMenor = 0;
			for (int i = 1; i < numeros.size(); i++) {
				if (numeros.get(i) < menor) {
					menor = numeros.get(i);
					posMenor = i;
				}
			}
			return posMenor;
		}

		private static int[] generarAleatorios(int tam) {
			int[] numer = new int[tam];
			Random rand = new Random();
			for (int i = 0; i < tam; i++) {
				numer[i] = rand.nextInt(100) + 1;
			}
			return numer;
		}

		private static int obtenerEntero(String mensaje) {
			int valor = 0;
			Scanner scanner = new Scanner(System.in);
			System.out.println(mensaje);
			try {
				valor = scanner.nextInt();
			} catch (Exception e) {
				System.err.println("¡Error! Debes introducir un numero entero.");
				valor = obtenerEntero(mensaje);
			}
			return valor;
		}

	}
	
