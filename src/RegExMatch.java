import java.util.Arrays;

/**
 * 
 * @author Vivek
 * 
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 */
public class RegExMatch {

	public static void main(String[] args) {
		
		String[] s = {"aa", "aa", "ab", "aab", "mississippi"};
		String[] p = {"a", "a*", ".*", "c*a*b", "mis*is*p*."};
		boolean[] ans = new boolean[s.length];
		for(int i=0; i<s.length; i++) {
			ans[i] = isMatch(s[i], p[i]);
		}
		System.out.println(Arrays.toString(ans));
		
	}
	
	static public boolean isMatch(String s, String p) {
        return isMatchHelper(s,0,p,0);
    }
    
    static boolean isMatchHelper(String s, int spos, String p, int ppos) {
        // System.out.println(spos+" "+ppos);
        if(spos == s.length() && ppos == p.length()) {
            return true;
        }
        if(spos < s.length() && ppos == p.length()) {
            return false;
        }
        if(spos == s.length() && ppos < p.length()) {
            if(ppos<p.length()-1 && p.charAt(ppos+1) == '*') {
                return isMatchHelper(s, spos, p, ppos+2);
            } else {
                return false;
            }
        }
        if((s.charAt(spos) == p.charAt(ppos)) || (p.charAt(ppos) == '.')) {
            if(ppos<p.length()-1 && p.charAt(ppos+1) == '*') {
                return isMatchHelper(s, spos, p, ppos+2) || isMatchHelper(s, spos+1, p, ppos) || isMatchHelper(s, spos+1, p, ppos+2);
            } else {
                return isMatchHelper(s, spos+1, p, ppos+1);
            }
        }
        if(ppos<p.length()-1 && p.charAt(ppos+1) == '*') {
            return isMatchHelper(s, spos, p, ppos+2);
        } else {
            return false;
        }
    }

}
