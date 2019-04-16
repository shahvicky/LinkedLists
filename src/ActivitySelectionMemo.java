import java.util.Arrays;

public class ActivitySelectionMemo {
	public static int counter = 0;

	public static void main(String[] args) {

		/*int[] start = {1,0,5,5, 9, 9, 10,10,16};
		int[] end =   {4,4,9,10,12,14,14,15,20};*/
		
		int[] start = {1,3,0,5,3,5,6, 8, 8, 2, 12};
		int[] end =   {4,5,6,7,9,9,10,11,12,14,16};
		int n = start.length;
		int[] max = new int[n];
		int[] memo = new int[n];
		for(int i=0; i<memo.length;i++) {
			memo[i] = Integer.MIN_VALUE;
		}
		for(int i=0; i<n; i++){
			if(memo[i] >= 0) {
				max[i] = memo[i];
				System.out.println("Here");
			} else {
				max[i] = aspHelper(start, end, i, n, memo);
			}
			
//			max[i] = aspHelper(start, end, i, n, memo);
		}
		
		System.out.println(Arrays.toString(max));
		System.out.println(Arrays.toString(memo));
	}
	

	private static int aspHelper(int[] start, int[] end, int i, int n, int[] memo) {
		System.out.println(++counter);
		int sumHours = 0;
		int sumHours1 = 0;
		if(i < n) {
			sumHours = end[i] - start[i];
			if(memo[i] >= 0) {
				//System.out.println("YYYYYYY");
				return memo[i];
			}
			memo[i] = sumHours;
			for(int j=i+1; j<n; j++) {
				int temp = 0;
				if(start[j] >= end[i]) {
					temp = aspHelper(start, end, j, n, memo);
				}
				if(sumHours+temp > sumHours1) {
					sumHours1 = sumHours+temp;
					memo[i] = sumHours1;
				}
			}
		}
		return Math.max(sumHours, sumHours1);
	}
}
