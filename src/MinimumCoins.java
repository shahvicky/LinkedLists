import java.util.Arrays;
import java.util.Scanner;

public class MinimumCoins {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int coins[] = {1,2,5,10,20};
		int count[] = {10,2,3,2,2};
		System.out.println("Enter sum:");
		int n = scan.nextInt();
		int sum[] = new int[n+1];
		Arrays.fill(sum, Integer.MAX_VALUE);
		sum[0] = 0;
		for(int i=0; i<coins.length; i++) {
			for(int j=1; j<sum.length; j++) {
				if(coins[i]<=j) {
					if(sum[j-coins[i]]+1<sum[j]) {
						sum[j] = sum[j-coins[i]]+1;
					}
				}
			}
		}
		System.out.println(Arrays.toString(sum));
		
		coinChange(13,coins, count);
	}
	
	public static void coinChange(int max_value, int coins[], int count[]) {
		int coins_sz = coins.length;
		int dp[] = new int[max_value + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int partial_sum = 0;
		for (int i = 0; i < coins_sz; i++) {
			partial_sum += coins[i] * count[i];
			for (int j = coins[i]; j <= partial_sum && j <= max_value; j++) {
				dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
			}
		}
		for (int i = 1; i <= max_value; i++) {
			System.out.println("Coin value = " + i + ", Minimum number of coins = " + dp[i]);
		}
	}
	
	public static int coinChangeRecur(int max_value, int[] coins, int[] count, int partial_sum, int[] dp, int i) {
		
		
		
		
		return 0;
	}

}
