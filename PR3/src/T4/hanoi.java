package T4;

public class hanoi {
	private static void hanoiRec(int tam, char origen, char destino, char auxiliar) {
		if(tam ==1) {
			System.out.println("Muevo dentro de");
		}else {
			
		
		hanoiRec(tam-1, origen, auxiliar, destino);
		System.out.println("Nuevo disco" + tam + " de " + origen + "a" + destino);
		hanoiRec(tam-1, auxiliar, destino, origen);
		}
	}
	public static void main(String[] args) {
		hanoiRec(3, 'a', 'c', 'b');
		
	}
	

}
