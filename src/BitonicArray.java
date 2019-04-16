
public class BitonicArray {

	public static void main(String[] args) {

		int[] a = {1,3,4,5,2};
		BitonicArray array = new BitonicArray();
		int x =array.bitonicFind(a);
		System.out.println(x);
	}

	private int bitonicFind(int[] a) {

		return bitonicHelper(a,0,a.length-1);

	}

	private int bitonicHelper(int[] a, int p, int r) {
		if(r-p+1<3){
			return -1;
		}
		int q=(p+r)/2;
		int left = a[q-1];
		int right = a[q+1];
		if(a[q] > left && a[q] < right) {
			return bitonicHelper(a, q, r);
		} else if(a[q] < left && a[q] > right) {
			return bitonicHelper(a, p, q);
		} else{
			return a[q];
		}
		
	}

}
