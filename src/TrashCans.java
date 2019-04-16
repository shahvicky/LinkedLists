

import java.util.Arrays;


//given  1.01 <= weight[i] <= 3.0


public class TrashCans {

	public static void main(String[] args) {
//		double[] weights = {1.01, 1.99, 2.5, 1.01};
		double[] weights = {1.5, 1.5, 1.5, 1.5};
		double max = 3.0;
		Arrays.sort(weights);
		
		int start = 0, end = weights.length-1;
		int trips = 0;
		while(start<=end) {
			if(weights[start]+weights[end] <=max) {
				start++;
				end--;
				trips++;
			}
			else {
				end--;
				trips++;
			}
		}
		
		System.out.println(trips);
	}
	

}
