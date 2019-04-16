import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRange {

	public static void main(String[] args) {
		int[] arr = {10};
		
		List<int[]> res = new ArrayList<>();
		int curr = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] - curr > 1) {
				int[] temp = {curr+1, arr[i]-1};
				res.add(temp);
			}
			curr = arr[i];
		}
		if(curr < 99) {
			int[] temp = {curr+1, 99};
			res.add(temp);
		}
		for(int[] a : res) {
			System.out.println(Arrays.toString(a));
		}
	}

}
