/*******************dirty, incorrect code***************/
public class DeleteModify {

	public int minOpr(String s1, String s2) {
		if (s1.equalsIgnoreCase(s2)) {
			return 0;
		}
		if (s1.equalsIgnoreCase("")) {
			return s2.length();
		}
		if (s2.equalsIgnoreCase("")) {
			return s1.length();
		}

		// case for modify
		if (s1.length() == s2.length()) {
			if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
				s1 = s1.substring(0, s1.length() - 1);
				s2 = s2.substring(0, s2.length() - 1);
				return minOpr(s1, s2);
			} else if (s1.charAt(s1.length() - 1) != s2.charAt(s2.length() - 1)) {
				/*
				 * System.out.println("Modify s1 char "
				 * +s1.charAt(s1.length()-1)+" to "+s2.charAt(s2.length()-1));
				 */ // s1 = s1.substring(0, s1.length()-2) +
					// s2.charAt(s2.length()-1);
				return findMin(minOpr(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)) + 1,
								minOpr(s1.substring(0, s1.length() - 1), s2)+1,
								minOpr(s1, s2.substring(0, s2.length() - 1))+1
								);
			}
		}

		// cases for delete
		else {
			if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
				s1 = s1.substring(0, s1.length() - 1);
				s2 = s2.substring(0, s2.length() - 1);
				return minOpr(s1, s2);
			} else if (s1.charAt(s1.length() - 1) != s2.charAt(s2.length() - 1)){
				return findMin(minOpr(s1.substring(0, s1.length() - 1), s2)+1,
						minOpr(s1, s2.substring(0, s2.length() - 1))+1,
						minOpr(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1))+2);
			}
		}

		
		 /** if(s1.length()<s2.length()){ if(s1.charAt(s1.length()-1) ==
		 * s2.charAt(s2.length()-1)){ return minOpr(s1.substring(0,
		 * s1.length()-1), s2.substring(0,s2.length()-1)); }else{
		 * System.out.println("Delete s2 char "+s2.charAt(s2.length()-1)+
		 * " and continue to check"); return
		 * minOpr(s1,s2.substring(0,s2.length()-1))+1; } }
		 * if(s1.length()>s2.length()){ if(s1.charAt(s1.length()-1) ==
		 * s2.charAt(s2.length()-1)){ return minOpr(s1.substring(0,
		 * s1.length()-1), s2.substring(0,s2.length()-1)); }else{
		 * System.out.println("Delete s1 char "+s1.charAt(s1.length()-1)+
		 * " and continue to check"); return minOpr(s1.substring(0,
		 * s1.length()-1),s2)+1; } }*/
		 

		return -1;

	}

	public int findMin(int a, int b, int c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}
	/*public int getMin(int a , int b){
		
	}*/

	public static void main(String[] args) {

		DeleteModify deleteModify = new DeleteModify();
		String s1 = "abad";
		String s2 = "xaba";
		int count = deleteModify.minOpr(s1, s2);
		System.out.println(count);
	}

}
