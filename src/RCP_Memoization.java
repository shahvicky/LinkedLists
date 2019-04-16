import java.util.Arrays;

public class RCP_Memoization {

	public static void main(String[] args) {

		int[] prices = {0,1, 5, 8, 9, 12, 17, 17, 21, 24, 30};
		int len = prices.length;
		int[] max = new int[len];
		for(int i=0; i<max.length;i++) {
			max[i] = Integer.MIN_VALUE;
		}
		//System.out.println(Arrays.toString(max));
		int ans = RCP_Helper(prices, len-1, max);
		System.out.println(ans);
		System.out.println(Arrays.toString(max));
	}

	private static int RCP_Helper(int[] prices, int len, int[] max) {
		if(max[len] >= 0) {
			return max[len];
		}
		int temp = Integer.MIN_VALUE;
		if(len == 0) {
			max[len] = 0;
			return 0;
		} else {
			for (int j=1; j<=len; j++) { 
				temp = Math.max(temp, prices[j] + RCP_Helper(prices, len-j, max));
			}
		}
		max[len] = temp;
		return max[len];
	}

	
	private static void RCP_Limits(int[] limits, int[] prices) {
		
	}
}
