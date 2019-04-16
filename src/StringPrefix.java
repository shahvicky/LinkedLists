
public class StringPrefix {

	public String prefix(String[] str) {

		StringBuffer common = new StringBuffer(str[0]);

		int i = 1;
		while (i < str.length) {

			StringBuffer curr_com = new StringBuffer();

			for (int k = 0; k < str[i].length() && k < common.length(); k++) {

				if (Character.toLowerCase(common.charAt(k)) == Character.toLowerCase(str[i].charAt(k))) {
					curr_com.append(common.charAt(k));
				} else {
					break;
				}
			}
			i++;
			common = curr_com;
		}
		return common.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPrefix prefix = new StringPrefix();
		String[] str = { "vinay", "vinyak", "Vinaya", "Vinayan" };
		String data = prefix.prefix(str);
		System.out.println(data);

	}

}
