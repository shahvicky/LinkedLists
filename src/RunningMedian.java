import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	static double median= 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try{
			while(true) {
				int num = scan.nextInt();
				System.out.println(median(num));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static double median(int num) {
//		double median = 0;
		
		if(minHeap.size() == 0 && maxHeap.size() == 0) {
			minHeap.add(num);
			return num;
		}
		if(minHeap.size() != 0) {
			if(num >= minHeap.peek()) {
				minHeap.add(num);
			} else {
				maxHeap.add(num);
			}
		}
		
		if(minHeap.size() == maxHeap.size()) {
			median = ((double)minHeap.peek() + maxHeap.peek())/2;
		} else if(minHeap.size() - maxHeap.size() == 1) {
			median = minHeap.peek();
		} else if(maxHeap.size() - minHeap.size() == 1) {
			median = maxHeap.peek();
		} else if(minHeap.size() - maxHeap.size() > 1) {
			maxHeap.add(minHeap.poll());
			median = ((double)minHeap.peek() + maxHeap.peek())/2;
		} else if(maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.poll());
			median = ((double)minHeap.peek() + maxHeap.peek())/2;
		}
		System.out.println("max heap   "+maxHeap);
		System.out.println("min heap   "+minHeap);
		return median;
	}
}
