
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String str = "kbcdefedczp";
		int max1 = 0;
		String res = "";
		for(int i=0; i<str.length(); i++) {
			String palin = longestPalindrome(i, i, str);
			if(palin.length() > max1) {
				max1 = palin.length();
				res =  palin;
			}
		}
		for(int i=0; i<str.length()-1; i++) {
			String palin = longestPalindrome(i, i+1, str);
			if(palin.length() > max1) {
				max1 = palin.length();
				res = palin;
			}
		}
		System.out.println(max1);
		System.out.println(res);
	}
	
	static String longestPalindrome(int pos1, int pos2, String str) {
		
		while(pos1>=0 && pos2<=str.length()-1) {
			if(str.charAt(pos1) == str.charAt(pos2)) {
				pos1--;
				pos2++;
			} else {
//				pos1++;
//				pos2--;
				break;
			}
		}
		return str.substring((pos1+1), (pos2));
	}

}
