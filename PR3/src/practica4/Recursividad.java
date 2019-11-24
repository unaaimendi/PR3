package practica4;

public class Recursividad {

	
	//////////////////////////////// 1/2 ////////////////////////////////////
	
	private static void invertirFrase() {
		String word = "Te";
		String sentence = "Te quiero 3000";
		// System.out.println(invertirSentence(word));
		System.out.println(invertirSentence(sentence));

	}

	public static String invertirWord(String sentence2) {
		String[] words = sentence2.split(" ");
		if (words.length == 1) {
			return sentence2;
		} else {
			return invertirWord(sentence2.split(" ", 2)[1]) + " " + sentence2.split(" ", 2)[0];
		}
	}

	private static void invertirPalabra() {

		String sentence2 = "Te quiero 3000";

		System.out.println(invertirWord(sentence2));

	}

	private static String invertirSentence(String word) {

		if (word.length() == 1) {
			return word;

		} else {
			word = invertirSentence(word.substring(1)) + word.charAt(0);
			return word;
		}

	}

	//////////////////////////////////// 3 ///////////////////////////////////////
	

	private static void longAHexa() {
		long num = 3000;
		long num2 = 2000;
		System.out.println(convertir(num) + " En decimal " + num);

		System.out.println(convertir(num2) + " En decimal " + num2);

	}

	private static String convertir(Long n) {

		int resto = (int) (n % 16);

		String respuesta = "";
		if (n == 0) {
			return Integer.toString(0);
			
		} else {
			if (resto < 10) {
				respuesta = resto + respuesta;

			} else if (resto == 10) {
				respuesta = "A" + respuesta;

			} else if (resto == 11) {
				respuesta = "B" + respuesta;

			} else if (resto == 12) {
				respuesta = "C" + respuesta;
				
			} else if (resto == 13) {
				respuesta = "D" + respuesta;
				
			} else if (resto == 14) {
				respuesta = "E" + respuesta;
				
			} else if (resto == 15) {
				respuesta = "F" + respuesta;
				
			} else {
				int r = (int) (n / 16);
				respuesta = Integer.toString(r) + respuesta;
			}
			return convertir(n / 16) + respuesta;
		}

	}

	public static void main(String[] args) {
		invertirFrase();
		invertirPalabra();
		longAHexa();

	}

}