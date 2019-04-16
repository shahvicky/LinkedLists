
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageMatching {

	public static void main(String[] args) {
		String[] g1 = {"1111", "1000", "0110", "1000"};
		List<String> grid1 = new ArrayList<>(Arrays.asList(g1));
		String[] g2 = {"1111", "1000", "0110", "1001"};
		List<String> grid2 = new ArrayList<>(Arrays.asList(g2));
		
		int matching = findMatching(grid1, grid2);
		System.out.println(matching);
	}

	private static int findMatching(List<String> grid1, List<String> grid2) {
		if(grid1.size() != grid2.size() || grid1.size() == 0) {
			return 0;
		}
		int[][] g1 = new int[grid1.size()][grid1.get(0).length()];
		int[][] g2 = new int[grid2.size()][grid2.get(0).length()];
		for(int i=0; i<grid1.size(); i++) {
			String[] row1 = grid1.get(i).split("");
			String[] row2 = grid2.get(i).split("");
			for(int j=0; j<row1.length; j++) {
				g1[i][j] = Integer.parseInt(row1[j]);
				g2[i][j] = Integer.parseInt(row2[j]);
			}
		}
		int count = 0;
		for(int i=0; i<g1.length; i++) {
			for(int j=0; j<g1[i].length; j++) {
				if(g1[i][j] == 1 && g2[i][j] == 1) {
					if(isMatching(g1, g2, i, j)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private static boolean isMatching(int[][] g1, int[][] g2, int i, int j) {
		if(i<0 || i==g1.length || j<0 || j==g1[i].length) {
			return true;
		}
		if(g1[i][j] == 0 && g2[i][j] == 0) {
			return true;
		}
		boolean flag = true;
		if(g1[i][j] == 1 && g2[i][j] == 1) {
			g1[i][j] = 0;
			g2[i][j] = 0;
		} else {
			g1[i][j] = 0;
			g2[i][j] = 0;
			flag = false;
		}
		boolean left = isMatching(g1, g2, i, j-1);
		boolean right = isMatching(g1, g2, i, j+1);
		boolean up = isMatching(g1, g2, i-1, j);
		boolean down = isMatching(g1, g2, i+1, j);
		return flag && left && right && up && down;
	}

}
