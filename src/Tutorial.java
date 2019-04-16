import java.util.Scanner;
public class Tutorial {
	
	public static void main(String args[]){
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Enteryur grl name: ");
		String grlName = scanner.nextLine();*/
		
		/*Tuna tunaObject = new Tuna("yoyo");
		tunaObject.saying();
			Tuna object2 = new Tuna("yoyoyoyo");
		object2.saying();*/
		String s = "abc";
		//System.out.println(s.substring(0, s.length()-1));
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		c1.a = 15;
		System.out.println(c2.a);
		c2.average(1, 1);
		c2.average(1, 2);
		/*int arr[] = {2,3,4,1,2,3};
		change(arr);
		
		for(int x: arr){
			System.out.println(x);
		
		}
		
		
		
		int[][] array1 = {{1,2,3,4,1},{2,3,2},{7,1}};
		int[][] array2 = {{43,3,3,5},{3},{34,54}};
		display(array1);
		
		System.out.println(average(2,1,2,4,2,2,1,2));*/
		String str = "0-22222 22-22- 093";
		String sq =  str.replaceAll("[^0-9]", "");
		System.out.println(sq);
	}
	
	public static void change(int[] x){
		for(int i=0; i<x.length; i++){
			x[i]+= 5;
		}
	}
	
	public static void display(int x[][]){
		for(int row=0; row<x.length; row++){
			for(int col=0; col<x[row].length; col++){
				System.out.print(x[row][col]+"\t");
			}
			System.out.println();
		}
	}
	
	public static int average(int...numbers){
		int total=0;
		for(int x: numbers)
			total+=x;
		return total/numbers.length; 
	}
}
