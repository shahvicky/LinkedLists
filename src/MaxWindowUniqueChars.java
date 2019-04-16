import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Maximum lenght of unique elements in a string
 * input: "prabhat"
 * output: "prabh"
 * (ask if the chars are all in lower case, will there be space, will string be empty)
 * @author Vivek
 *
 */
public class MaxWindowUniqueChars {
	public static void main(String[] args) {
		
		String str = "taprabuhat";
		int max = 1;
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		int j=0;
		String res = ""+str.charAt(0);
		set.add(str.charAt(0));
		for(int i=1; i<str.length(); i++) {
			if(set.contains(str.charAt(i))) {
				while(true){
					if(str.charAt(j) == str.charAt(i)) {
						set.remove(str.charAt(j));
						j++;
						break;
					}
					set.remove(str.charAt(j));
					j++;
				}
			} 
			set.add(str.charAt(i));
			if(i-j+1 > max) {
				max = i-j+1;
				res = str.substring(j, i+1);
			}
			System.out.println(j+"  "+ i+" "+set+" "+str.substring(j,i+1));
		}
		System.out.println(max);
		System.out.println(res);
	}
}
