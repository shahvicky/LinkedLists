

import java.util.Arrays;

public class CountIn1stArrayLessThan2ndArray {

	public static void main(String[] args) {
		int[] arr1 = {7,0,4,1,2};
		int[] arr2 = {2,4,6};
		int[] res = new int[arr2.length];
		Arrays.sort(arr1);
		
		for(int i=0; i<arr2.length; i++) {
			int index = find(arr1, arr2[i]);
			res[i] = index+1;
		}
		
		System.out.println(Arrays.toString(res));
	}
	
	static int find(int[] arr, int k) {
		
		int start = 0, end = arr.length-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			
			if(start == end && arr[start] < k) {
				return start;
			}
			
			if(arr[mid] == k) {
				return mid;
			}
			if(arr[mid] < k && arr[mid+1] > k) {
				return mid;
			}
			if(arr[mid] < k) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return -1;
	}

}
