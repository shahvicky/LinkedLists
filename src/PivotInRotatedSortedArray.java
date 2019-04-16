
public class PivotInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = {4,5,6,1};
		int low = 0, high = arr.length-1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(low == high) {
				System.out.println(low);
				break;
			}
			if(arr[mid] > arr[mid+1]){ 
				System.out.println(mid+1);
				break;
			}
			if(arr[mid] > arr[low] || arr[mid] > arr[high]) {
				low = mid+1;
			} else {
				high = mid;
			}
		}
		
	}

}
