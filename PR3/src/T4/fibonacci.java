package T4;

public class fibonacci {

	
	private static int fibonacci(int n) {
		if(n == 1) {
			return 1;
			
		}else if(n==2){
			return 1;
			
		}else {
			return fibonacci(n-1) + fibonacci(n-2);

		}
	}
	public static void main(String[] args) {
		System.out.println(fibonacci(75));
	}
}
