package T4;

public class busquedaBinaria {

	private static void busquedaBinaria() {
		int[] v = {1, 2, 10, 11, 15, 17, 21, 43, 57, 83, 84, 85, 86, 87, 89, 110};
		int donde =busq(v, 87, 0, v.length-1 );
		System.out.println(donde);
	}
	//Busca el valor valorBuscado en el vector v engtre las posiciones ini y fin, ambas inclusive
	//Devuelve la posicion del valor si existe,  -1 si no existe
	//Funcionamiento:
	//	Calculamos la mitad
	//	Comparamos el valor buscado con el que hay en la mitad
	//		a) Son iguales - caso base: se devuelve
	//		b) El de la mitad es menor: buscar recursivamente en la mitad superior
	//		c) EL de la mitad es mayor: buscar recursivamente en la mitad inferior
	//	Caso base: vector sin valores (ini> fin) - se devulve -1
	private static int busq(int[] v, int valorBuscado, int ini, int fin) {
		if(ini>fin) {
			return -1;
		}else {
		int mitad = (ini + fin)/2; //ini devuelve un entero (centro lig. a la izquierda
		if (v[mitad] == valorBuscado) {
			//caso base encontrado
			return mitad;
		}else if (v[mitad] < valorBuscado) {
			return busq(v, valorBuscado, mitad+1, fin);
		}else {
			return busq(v, valorBuscado, ini, mitad-1);
		}
		
		}
		}
	public static void main(String[] args) {
		busquedaBinaria();
	}
	
	}