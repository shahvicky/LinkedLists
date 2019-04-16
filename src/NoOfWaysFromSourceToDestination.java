import java.util.Stack;

public class NoOfWaysFromSourceToDestination {
	
	public static void main(String[] args) {
		
		int[][] grid = new int[][]{
			{-1,0,1,0,1},
			{1,1,1,1,1},
			{0,0,1,0,1},
			{0,0,1,1,1}
		};
		
		int[] source = new int[]{0,0};
		Stack<String> st = new Stack<>();
		int n = findWays(grid, source[0], source[1], st);
		System.out.println(n);
	}
	
	static int findWays(int[][] grid, int i, int j, Stack<String> stack) {
		
		if(i<0 || i==grid.length || j<0 || j==grid[i].length || grid[i][j] == 0){
			return 0;
		}
		else if(i==grid.length-1 && j==grid[i].length-1 && grid[i][j] == 1) {
			System.out.println(stack);
			return 1;
		}
		
		stack.push("("+((int)i+1)+","+j+")");
		int L=findWays(grid, i+1, j, stack) ;
		stack.pop();
		stack.push("("+i+","+((int)j+1)+")");
		int R=findWays(grid, i, j+1, stack);
		stack.pop();
		return L+R;
	}
}
