
public class ISBN {

	public static void main(String[] args) {
		String isbn = null;
		System.out.println(answer(isbn));
	}
	
	public static boolean answer(String isbn) {
		if(isbn == null)
			return false;
        String str = isbn.replaceAll("[- ]", "");
        System.out.println(str.length());
        if(str.length() != 13 && str.length() != 10) {
            return false;
        } else if(str.length() == 13) {
            return checkISBN13(str);
        } else {
            return checkISBN10(str);
        }
        
    }
    
    static boolean checkISBN13(String isbn13) {
        int sum = 0;
        for(int i=0; i<12; i++) {
            if(i%2 == 0) {
                sum += (int)(isbn13.charAt(i) - '0');
            } else {
                sum += 3*((int)(isbn13.charAt(i) - '0'));
            }
        }
        int check = (10 - sum%10)%10;
        if(check == (int)(isbn13.charAt(12) - '0')) {
            return true;
        }
        return false;
    }
    
    static boolean checkISBN10(String isbn10) {
        int sum = 0;
        for(int i=0; i<9; i++) {
            sum += ((int)(isbn10.charAt(i) - '0'))*(10-i);
        }
        int last = isbn10.charAt(9) == 'X' ? 10 : (int)(isbn10.charAt(9) - '0');
        System.out.println(last);
        sum += last;
        System.out.println(sum);
        if(sum%11 != 0) {
            return false;
        }
        return true;
    }


}
