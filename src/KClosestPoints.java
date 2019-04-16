

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {

	public static void main(String[] args) {
		List<int[]> input = new ArrayList<>();
		input.add(new int[]{3,1});
		input.add(new int[]{-1,0});
		input.add(new int[]{1,1});
		input.add(new int[]{2,2});
		input.add(new int[]{2,-2});
		input.add(new int[]{1,-1});
		int k = 3;
		List<int[]> res = closest(input, k);
		for(int[] point : res) {
			System.out.println(" "+Arrays.toString(point));
		}
		
	}
	
	static List<int[]> closest(List<int[]> input, int k) {
		List<int[]> ans = new ArrayList<>();
		double[] dist = new double[input.size()];
		
		for(int i=0; i<input.size(); i++){
			int[] point = input.get(i);
			dist[i] = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
		}		
		PriorityQueue<Double> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
		for(double d : dist) {
			if(maxHeap.size() < k) {
				maxHeap.add(d);
			} else {
				if(maxHeap.peek()>d) {
					maxHeap.poll();
					maxHeap.add(d);
				}
			}
		}
		double max = maxHeap.peek();
		int counter = 0;
		for(int i=0; i<dist.length; i++) {
			if(counter < k){
				if(dist[i] < max){
					ans.add(input.get(i));
					counter++;
				}
			} else {
				break;
			}
		}
		if(counter<k){
			for(int i=0; i<dist.length; i++) {
				if(counter < k){
					if(dist[i] == max){
						ans.add(input.get(i));
						counter++;
					}
				} else {
					break;
				}
			}
		}
		
		return ans;
	}

}
