import java.util.Arrays;
import java.util.Collections;

public class LongestNonDecreasingSequence {

	public static void main(String[] args) {

		
		int[] arr = {10,9,2,5,3,7,101,7};
		int[] no = new int[arr.length];
		no[0] = 1;
		int max = no[0];
		for(int i=1; i<arr.length; i++) {
			no[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					if(no[j]+1 > no[i]) {
						no[i] = no[j] +1;
					}
				}
			}
			max = Math.max(max, no[i]);
		}
		System.out.println(Arrays.toString(no));
//		int max = no[0];
//
//        for (int i = 1; i < no.length; i++) {
//            if (no[i] > max) {
//              max = no[i];
//            }
//        }
		System.out.println("Answer:" + max);
		
	}

}
