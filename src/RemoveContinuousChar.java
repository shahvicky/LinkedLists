
public class RemoveContinuousChar {
	

	public static void main(String[] args) {
		
		String str = "aaabccddd";
	
		for(int i=1;i<=str.length()-1;i++){
			if(str.charAt(i) == str.charAt(i-1)){
				str =str.substring(0,i-1)+ str.substring(i+1, str.length());
				//System.out.println(str);
				i=1;
			}
		}
		System.out.println(str);

	}

}
