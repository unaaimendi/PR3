package T4;

public class Factorial {

	public static void main(String[] args) {
		prueba1();
		factorial();
		factorial2();
		prodConSuma();
		aLaLuna();
	}
	public static void prodConSUma() {
		System.out.println(producto(6,5));
	}
	private static int producto(int m, int n) {
		if(n == 0) {
			return 0;
			
		}else {
			return n + producto(m, n-1 );
		}
	}
	
	private static void fact2(int nInicial, long valorInicial, int nFinal) {
		if(nInicial == nFinal) {
			System.out.println(valorInicial);
			
		}else {
			fact2(nInicial + 1, valorInicial*(nInicial + 1), nFinal);
		}
	}
	private static void factorial() {
		System.out.println(fact(5));
	}
	private static void factorial2() {
		fact2(0, 1, 6);
	}
	private static long fact(int n) {
		if(n==0) {
			return 1;
			
		}else {
			return n*fact(n-1);
		}
		
	}
	private void aLaLuna() {
		calcDobleces(0.00015, 384400000.0, 0);
	}
	public void calcDobleces(double grosor, double distancia, int numDobleces) {
		if(grosor>= distancia) {
			System.out.println(numDobleces);
			
		}else {
			calcDobleces(grosor*2, distancia, numDobleces+ 1);
		}
	}
}
