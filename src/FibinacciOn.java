
public class FibinacciOn {

	public static void main(String[] args) {

		int n=5;
		FibinacciOn fibinacciOn = new  FibinacciOn();
		int fN = fibinacciOn.fibonacci(n-1);
		System.out.println(fN);
		
	}

	private int fibonacci(int n) {
		int[] A = new int[n+1];
		A[0] = 1;
		A[1] = 2;
		for(int i=2; i<=n; i++){
			A[i] = A[i-1] + A[i-2];
		}
		
		return A[n];
	}

}
