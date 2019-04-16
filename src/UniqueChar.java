

import java.util.Arrays;

public class UniqueChar {

	public static void main(String[] args) {
		String str = "wqeasdrfthgyuikj";
		System.out.println(isUnique_(str));
	}
	
	static boolean isUnique(String str) {
		boolean[] arr = new boolean[256];
		int len = str.length();
		for(int i=0; i<len; i++) {
			int index = (int)str.charAt(i);
			if(arr[index])
				return false;
			arr[index] = true;
		}
		System.out.println(Arrays.toString(arr));
		return true;
	}
	//without any extra data structure
	static boolean isUnique_(String str) {
		int val = str.charAt(0)- 'a';
		System.out.println(val);
		System.out.println(1<<val);
		return false;
	}
}
