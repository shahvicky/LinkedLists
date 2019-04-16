

import java.util.ArrayList;
import java.util.List;

public class MatchingRegions {

	public static void main(String[] args) {
		List<String> grid1 = new ArrayList<>();
		List<String> grid2 = new ArrayList<>();
		grid1.add("111");
		grid1.add("100");
		grid1.add("100");
		grid2.add("111");
		grid2.add("100");
		grid2.add("101");
		
		char[][] gridOne = new char[grid1.size()][grid1.size()];
		char[][] gridTwo = new char[grid1.size()][grid1.size()];
		for(int i=0; i<gridOne.length; i++) {
			char[] arr1 = grid1.get(i).toCharArray();
			gridOne[i] = arr1;
			char[] arr2 = grid2.get(i).toCharArray();
			gridTwo[i] = arr2;
		}
		for(int i=0; i<gridOne.length; i++) {
			for(int j=0; j<gridOne[i].length; j++) {
				System.out.print(gridOne[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}
	
	public static void merge(char[][] grid, int i, int j){
	    int m=grid.length;
	    int n=grid[0].length;
	 
	    if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1')
	        return;
	 
	    grid[i][j]='X';
	 
	    merge(grid, i-1, j);
	    merge(grid, i+1, j);
	    merge(grid, i, j-1);
	    merge(grid, i, j+1);
	}

}
