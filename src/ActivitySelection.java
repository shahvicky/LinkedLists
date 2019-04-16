import java.util.Arrays;

public class ActivitySelection {

	public static void main(String[] args) {

		int[] start = {1,0,5,5, 9, 9, 10,10,16};
		int[] end =   {4,4,9,10,12,14,14,15,20};
		/*
		int[] start = {1,3,0,5,3,5,6, 8, 8, 2, 12};
		int[] end =   {4,5,6,7,9,9,10,11,12,14,16};*/
		int n = start.length;
		int[] max = new int[n];
		
		for(int i=0; i<n; i++){
			max[i] = aspHelper(start, end, i, n);
		}
		
		System.out.println(Arrays.toString(max));
		
	}
	

	private static int aspHelper(int[] start, int[] end, int i, int n) {
		int sumHours = 0;
		int sumHours1 = 0;
		if(i < n) {
			sumHours = end[i] - start[i];
			for(int j=i+1; j<n; j++) {
				int temp = 0;
				if(start[j] >= end[i]) {
					temp = aspHelper(start, end, j, n);
				}
				if(sumHours+temp > sumHours1) {
					sumHours1 = sumHours+temp;
					//memo[j] = sumHours1;
				}
				
			}
		}
		return Math.max(sumHours, sumHours1);
	}
}
