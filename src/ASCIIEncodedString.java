

import java.util.HashMap;

public class ASCIIEncodedString {

	public static void main(String[] args) {
		/*
		 * input: "23511011501782351112179911801562340161171141148"
		 * ouput: "Truth Always Wins"
		 * 
		 * input: "2312179862310199501872379231018117927"
		 * output: "Have a Nice Day"
		 * 
		 * */
		String encoded = "1219950180111108236115111016623101401611235115012312161151110101111127";
		
		System.out.println(decode(encoded));
	}
	
	static String decode(String encoded) {
		
		HashMap<Integer, Character> map = new HashMap<>();
		for(int i=65; i<91; i++) {
			map.put(i, (char)i);
		}
		for(int i=97; i<123; i++) {
			map.put(i, (char)i);
		}
		map.put(32, ' ');
		
		StringBuilder str = new StringBuilder(encoded);
		StringBuilder res = new StringBuilder();
		str.reverse();
		int pos = 0;
		for(int i=2; i<=str.length(); i++) {
			String no = str.substring(pos,i);
			if(map.containsKey(Integer.parseInt(no))) {
				res.append(map.get(Integer.parseInt(no)));
				pos = i;
			}
		}

		return res.toString();
	}

}
