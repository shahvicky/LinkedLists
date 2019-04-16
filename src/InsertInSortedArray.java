
public class InsertInSortedArray {

	public static void main(String[] args) {
		int[] arr = {1};
		int k = 3;
		int start = 0, end = arr.length-1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(arr[mid] == k) {
				System.out.println(mid);
			}
			if(k<arr[mid]) {
				end = mid;
			} else if(k>arr[mid]) {
				start = mid;
			}
			
		}
		
	}

}
