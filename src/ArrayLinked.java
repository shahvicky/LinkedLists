
public class ArrayLinked {
	
	public static void main(String[] args) {
		int[] a = {1,4,5,3,2,-1};
		
		int l = solution(a);
		System.out.println(l);
	}
	
	static int solution(int[] a) {
		int i=0;
		int count = 1;
		while(a[i] != -1) {
			i=a[i];
			count++;
		}
		
		return count;
		
	}
	
	

}
