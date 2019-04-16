import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		int[] size = {1,2,3,4,5,6,7,8,9,10};
		int[] limit = {7,1,3,4,3,4,3,4,3,5};
		int[] prices = {1, 5, 8, 9, 12, 17, 17, 21, 24, 30};
		int len = prices.length;
		int[] max = new int[len];
		
		rcpCuts(prices);
		
		
		
		for(int i=0; i<len; i++) {
			max[i] = prices[i];
			for(int j=1; j<=i; j++) {
				int total = prices[j-1]+max[i-j];
				if(total > max[i]) {
					max[i] = total;
				}
			}
		}
//		System.out.println(Arrays.toString(max));
	}
	
	public static int rcpLimit(int[] size, int[] limit, int[] price, int len) {
		
		
		
		
		
		return 0;
	}
	
	public static void rcpCuts(int[] prices) {
		int[] cuts = new int[prices.length];
		Arrays.fill(cuts, 1);
		int[] max= new int[prices.length];
		int len = prices.length;
		for(int i=0; i<len; i++) {
			max[i] = prices[i];
			for(int j=1; j<=i; j++) {
				int total = prices[j-1]+max[i-j];
				if(total > max[i]) {
					max[i] = total;
					cuts[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(max));
		System.out.println(Arrays.toString(cuts));
		
	}

}
