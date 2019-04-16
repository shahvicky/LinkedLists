
public class ThreePartitionSumEqual {

	public static void main(String[] args) {

//		TwoPartitionwithEqualSum
//		int[] arr = {5,2,9,5,9};
		int[] arr = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
		int sum = 0;
		for(int i:arr) {
			sum += i;
		}
		if(sum%2 != 0)
			System.out.println(sum+" "+false);
		else{
			System.out.println(twoPartition(arr, sum/2));
		}	
	}

	static boolean twoPartition(int[] arr, int sum) {
		return twoPartitionHelper(arr, 0, 0, 0, sum);
	}
	
	static boolean twoPartitionHelper(int[] arr, int i, int sum1, int sum2, int sum) {
	
		if(sum1 == sum2 && sum1 == sum)
			return true;
		if(i==arr.length)
			return false;
		return twoPartitionHelper(arr, i+1, sum1+arr[i], sum2, sum) || twoPartitionHelper(arr, i+1, sum1, sum2+arr[i], sum);
	}
}
