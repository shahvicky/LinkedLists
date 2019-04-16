
public class LargestPerimeterIsland {
	static int largest = 0;
	public static void main(String[] args) {
		int[][] mat = {
			{1,1,0,0,0},
			{1,1,0,0,0},
			{0,0,0,0,1},
			{0,0,1,1,1},
			{0,0,0,1,1}
		};
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				largestIsland(mat, i, j);
			}
		}
		
		System.out.println(largest);
	}
	
	static int largestIsland(int[][] mat, int i, int j) {
		if(i<0 || i==mat.length || j<0 || j== mat[i].length || mat[i][j] == 0 || mat[i][j] == -1)
			return 0;
		
		int peri = 0;
		if((i==0) || (i>0 && mat[i-1][j] == 0))
			peri += 1;
		if((i==mat.length-1) || (i<mat.length-1 && mat[i+1][j] == 0))
			peri += 1;
		if((j==0) || (j>0 && mat[i][j-1] == 0))
			peri += 1;
		if((j==mat[i].length-1) || (j<mat[i].length-1 && mat[i][j+1] == 0))
			peri += 1;
		mat[i][j] = -1;
		int up = largestIsland(mat, i-1, j);
		int down = largestIsland(mat, i+1, j);
		int left = largestIsland(mat, i, j-1);
		int right = largestIsland(mat, i, j+1);
		
		largest = Math.max(largest, peri + up + down + left + right);
		
		return peri + up + down + left + right;
	}

}
