import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingElement {

	public static void main(String[] args) {
		String s = "abcdgfadfshejn";
		char[] arr = s.toCharArray();
		int[] alpa = new int[26];
		alpa[s.charAt(0)-97] = 1;
		int max = 1, pos1 = 0, pos2 = 0, currMax = 1, currPos1 = 0, currPos2 = 0;
		for(int i=1; i<arr.length; i++) {
			if(alpa[arr[i]-97]==1) {
				while(alpa[arr[i]-97]!=0) {
					alpa[arr[currPos1]-97] = 0;
					currPos1++;
				}
			}
			alpa[arr[i]-97] = 1;
			currPos2++;
			currMax = currPos2-currPos1+1;
			if(currMax > max) {
				max = currMax;
				pos1 = currPos1;
				pos2 = currPos2;
			}
		}
		System.out.println(s.substring(pos1, pos2+1));
	}

}
