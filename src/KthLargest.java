import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetcode 215
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1: Input: [3,2,1,5,6,4] and k = 2 Output: 5
 * 
 * Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
 * 
 * 
 * @author Vivek
 *
 */

public class KthLargest {
	public static void main(String[] args) {
		int[] nums = {7,6,8,5};
		int k = 2;
		System.out.println(kthLargest_partition(nums, k));
	}
	
	static int kthLargest_minHeap(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        int len = nums.length;
        for(int i=0; i<len; i++) {
            if(minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else {
                if(minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
	}
	
	static int kthLargest_partition(int[] nums, int k) {
		int i = 0, j = nums.length-1;
		return kthLargest_partition_helper(nums, i, j, k);
	}
	
	private static int kthLargest_partition_helper(int[] arr, int i, int j, int k) {
		int pivot = partition(arr, i, j);
		System.out.println("Pivot---> "+pivot);
		if(pivot == arr.length-k) {
			return arr[pivot];
		} else if(pivot > arr.length-k) {
			return kthLargest_partition_helper(arr, i, pivot-1, k);
		} else {
			return kthLargest_partition_helper(arr, pivot+1, j, k);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		int val = arr[end];
		int pos = start;
		for(int i = start; i < end; i++) {
			if(arr[i] <= val) {
				int temp = arr[i];
				arr[i] = arr[pos];
				arr[pos] = temp;
				pos++;
				System.out.println(Arrays.toString(arr));
			}
		}
		int temp = arr[end];
		arr[end] = arr[pos];
		arr[pos] = temp;
		System.out.println("--------------------");
		return pos;
	}
}
