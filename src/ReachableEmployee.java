

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Complete the 'order' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. UNWEIGHTED_INTEGER_GRAPH employees
 *  2. INTEGER host
 */

/*
 * For the unweighted graph, <name>:
 *
 * 1. The number of nodes is <name>Nodes.
 * 2. The number of edges is <name>Edges.
 * 3. An edge exists between <name>From[i] and <name>To[i].
 *
 */

public class ReachableEmployee {

	public static void main(String[] args) {
		int employeesNodes = 5;
		int host = 4;
		int[] from = {1,1,2,3,1};
		int[] to = {2,3,4,5,5};
		
//		int employeesNodes = 3;
//		int host = 4;
//		int[] from = {1,2,2};
//		int[] to = {2,3,4};
		List<Integer> employeesFrom = new ArrayList<>();
		for(int i: from) {
			employeesFrom.add(i);
		}
		List<Integer> employeesTo = new ArrayList<>();
		for(int i: to) {
			employeesTo.add(i);
		}
		
		
		System.out.println(order(employeesNodes, employeesFrom, employeesTo, host));
		
	}
	
	public static List<Integer> order(int employeesNodes, List<Integer> employeesFrom, List<Integer> employeesTo, int host) {
		List<Integer> res = new ArrayList<>();
		 if(employeesFrom.size() == 0 || employeesFrom.size() != employeesTo.size()) {
			 return res;
		 }
		 int noOfEdges = employeesFrom.size();
		 Map<Integer, Set<Integer>> edges = new HashMap<>();
		 for(int i=0; i<noOfEdges; i++) {
			 edges.put(employeesFrom.get(i), new TreeSet<>());
			 edges.put(employeesTo.get(i), new TreeSet<>());
		 }
		 for(int i=0; i<noOfEdges; i++) {
			 edges.get(employeesFrom.get(i)).add(employeesTo.get(i));
			 edges.get(employeesTo.get(i)).add(employeesFrom.get(i));
		 }
		 for(Map.Entry<Integer, Set<Integer>> entry : edges.entrySet()) {
			 System.out.println(entry.getKey() +"  "+ entry.getValue());
		 }
		 Set<Integer> visited = new HashSet<>();
		 Queue<Integer> queue = new LinkedList<>();
		 queue.add(host);
		 visited.add(host);
		 while(!queue.isEmpty()) {
			 int node = queue.poll();
			 for(int neighbor : edges.get(node)) {
				 if(!visited.contains(neighbor)) {
					 visited.add(neighbor);
					 queue.add(neighbor);
				 }
			 }
		 }
		 
		return res;
	}

	
}

class test {
	static int droppedRequests(List<Integer> requestTime) {
	    TreeMap<Integer, Integer> tree = new TreeMap();
	    for (int i : requestTime) {
	        tree.put(i, tree.getOrDefault(i, 0) + 1);
	    }
	    int total = 0;
	    for (int i : tree.keySet()) {
	        if (tree.get(i) > 3) {
	            total += tree.get(i) - 3;
	        }
	    }
	    int[][] arr = new int[tree.size()][2];
	    int k = 0;
	    for (int i : tree.keySet()) {
	        arr[k][0] = i;
	        arr[k][1] = tree.get(i);
	        k++;
	    }
	    int start = 0;
	    int sum = 0;
	    for (int j = 0; j < arr.length; j++) {
	        while (arr[j][0] - arr[start][0] >= 10) {
	            total += Math.max(0, sum - 20);
	            sum -= arr[start][1];
	            // /System.out.println(sum +" "+start);
	            start++;
	        }
	        sum += arr[j][1];
	    }

	    // System.out.println(sum);
	    total += Math.max(0, sum - 20);
	    start = 0;
	    sum = 0;
	    for (int j = 0; j < arr.length; j++) {
	        while (arr[j][0] - arr[start][0] >= 60) {
	            total += Math.max(0, sum - 60);
	            sum -= arr[start][1];
	            start++;
	        }
	        sum += arr[j][1];
	    }
	    total += Math.max(0, sum - 60);
	    // 1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7

	    return total;

	}

}

class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        
        return isMatchingHelper(str, pat, 0, 0);
    }
    
    boolean isMatchingHelper(char[] str, char[] patr, int strIndex, int patIndex) {
        if(strIndex == str.length && patIndex == patr.length) {
            return true;
        }
        if(strIndex == str.length) {
            return false;
        }
        if(patIndex == patr.length) {
            return false;
        }
        if(Character.isLetter(patr[patIndex])) {
            if(str[strIndex] != patr[patIndex]) {
                return false;
            } else {
                return isMatchingHelper(str, patr, strIndex+1, patIndex+1);
            }
        }
        
        if(patr[patIndex] == '?') {
            return isMatchingHelper(str, patr, strIndex+1, patIndex+1);
        }
        
        return isMatchingHelper(str, patr, strIndex+1, patIndex) || isMatchingHelper(str, patr, strIndex+1, patIndex+1);
    }
}

