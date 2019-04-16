import java.util.Arrays;

/**
 * 
 * @author Vivek
 * 
 *         You are given an array of positive and/or negative integers and a
 *         value K . The task is to find count of all sub-arrays whose sum is
 *         divisible by K?
 * 
 *         Examples :
 * 
 *         Input : arr[] = {4, 5, 0, -2, -3, 1}, K = 5 Output : 7 // there are 7
 *         sub-arrays whose is divisible by K // {4, 5, 0, -2, -3, 1} // {5} //
 *         {5, 0} // {5, 0, -2, -3} // {0} // {0, -2, -3} // {-2, -3}
 * 
 */
public class KSubsequencesSumDivisibleByK {

	public static void main(String[] args) {
		int arr[] = { 5,10,11,9,5 }; 
        int k = 5; 
        int n = arr.length; 
        System.out.println(subCount(arr, n, k)); 
        int arr1[] = { 1,2,3,4,1 }; 
        int k1 = 3; 
        int n1 = arr1.length; 
        System.out.println(subCount(arr1, n1, k1));
	}
	// Handles all the cases 
    // function to find all sub-arrays divisible by k 
    // modified to handle negative numbers as well 
    static int subCount(int arr[], int n, int k) 
    { 
        int mod[] = new int[k]; 
        Arrays.fill(mod, 0); 
        int cumSum = 0; 
        for (int i = 0; i < n; i++) { 
            cumSum += arr[i]; 
            mod[(cumSum % k)]++; 
        } 
        int result = 0; 
        for (int i = 0; i < k; i++) 
            if (mod[i] > 1) 
                result += (mod[i] * (mod[i] - 1)) / 2; 
        result += mod[0]; 
        return result; 
    }

}
