
public class NextCapital {

	public static void main(String[] args) {
	
		NextCapital obj = new NextCapital();

		String str = "nextcapital";
		
		String str1 = rule4(str);
		System.out.println(str1);
	}
	
	public static String rule1(String str) {
		String str1 = str.replace('s', '5');
		return str1.replace('S', '5');
	}
	
	public String rule2(String str) {
		if ((str.length() % 2 != 0) && str.length() > 1) {
			char mid = str.charAt((str.length()) / 2);
			int change = mid;
			if (Character.isDigit(mid)) {
				change = Character.getNumericValue(mid) * 2;

				String str1 = str.substring(0, str.length() / 2) + change
						+ str.substring(str.length() / 2 + 1, str.length());
				return str1;
			}
		}
		return str;
	}
	
	public static String rule3(String str) {
		String str1=str;
		if(str.length()%2 == 0) {
			char first = str.charAt(0);
			if(Character.isUpperCase(first)){
				first = Character.toLowerCase(first);
			}else{
				first = Character.toUpperCase(first);
			}
			
			char last = str.charAt(str.length()-1);
			if(Character.isUpperCase(last)){
				last = Character.toLowerCase(last);
			}else{
				last = Character.toUpperCase(last);
			}
			str1 = Character.toString(last) + str.substring(1,str.length()-1) + Character.toString(first);
		}	
		return str1;
	}
	
	public static String rule4(String str) {
		String name = "nextcapital";
		String str1 = str;
		if(str.toLowerCase().contains(name)){
			int index = str.toLowerCase().indexOf(name);
			String buffer = str.substring(index, index+4);
			StringBuffer b1 = new StringBuffer(buffer);
			b1.reverse();
			str1 = str.substring(0, index)+b1.toString()+str.substring(index+4, str.length());
			
		}
		return str1;
	}

}
