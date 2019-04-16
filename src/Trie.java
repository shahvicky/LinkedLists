import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Trie {
	static LinkedHashMap<String, String> hmap = new LinkedHashMap();
	int x[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
	int y[] = { 1, -1, 0, 0, 1, -1, 1, -1 };
	int alpha = 26;
	Node root;

	class Node {
		Node[] child = new Node[alpha];
		boolean leaf;

		Node() {
			leaf = false;
			for (int i = 0; i < alpha; i++)
				child[i] = null;
		}
	}

	void insert(String key) {
		int length = key.length();

		if (root == null)
			root = new Node();
		Node pcrawl = root;
		for (int j = 0; j < length; j++) {
			int index = key.toUpperCase().charAt(j) - 'A';
			if (pcrawl.child[index] == null)
				pcrawl.child[index] = new Node();
			pcrawl = pcrawl.child[index];
		}
		
		pcrawl.leaf = true;
	}

	static void makeGrid(List<String> list, List<String> output_list) {
		char[][] grid = new char[list.size()][list.get(0).length()];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = list.get(i).charAt(j);
			}
		}
		Trie l = new Trie();
		for (String t : output_list) {
			l.insert(t);
			hmap.put(t, "-1|-1");
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				l.searchTrie(grid, i, j, l.root, i, j);
			}
		}
	}

	void searchTrie(char[][] grid, int i, int j, Node root, int parent_i, int parent_j) {
		Node curr = search(grid[i][j], root, parent_i, parent_j, 0, 0, i, j, grid);
		if (curr == null) {
			return;
		}
		for (int k = 0; k < 8; k++) {
			searchTrie1(grid, i, j, curr, parent_i, parent_j, x[k], y[k]);
		}
	}

	void searchTrie1(char[][] grid, int i, int j, Node root, int parent_i, int parent_j, int x, int y) {
		i = i + x;
		j = j + y;
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		Node curr = search(grid[i][j], root, parent_i, parent_j, x, y, i, j, grid);
		if (curr == null) {
			return;
		}
		searchTrie1(grid, i, j, curr, parent_i, parent_j, x, y);
	}

	Node search(char c, Node root, int parent_i, int parent_j, int x, int y, int i, int j, char[][] grid) {
		int index = (int) (c - 'A');
		if (root == null || root.child[index]==null) {
			return null;
		}
		if (root.child[index].leaf) {
			StringBuilder ans = new StringBuilder();
			int temp_i = parent_i;
			int temp_j = parent_j;
			while (parent_i != i || parent_j != j) {
				ans.append(""+grid[parent_i][parent_j]);
				parent_i += x;
				parent_j += y;
			}
			ans.append(""+grid[parent_i][parent_j]);
			System.out.println(ans.toString()+" "+parent_i+" "+parent_j+" "+i+" "+j);
			hmap.put(ans.toString(), temp_i + "|" + temp_j);
		}
		System.out.println(c+ " "+root.leaf);
		//hmap.put(ans, temp_i + "|" + temp_j);
		return root.child[index];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		List<String> input_list = new ArrayList();
		List<String> output_list = new ArrayList();
		boolean flag = true;
		try {
			while (true) {
				String t = scan.nextLine();
				if (!flag && t.length() == 0) {
					break;
				}
				if (!flag)
					output_list.add(t.trim());
				if (t.length() != 0 && flag) {
					input_list.add(t.trim());
				} else {
					flag = false;
				}

			}

			makeGrid(input_list, output_list);
			System.out.println(hmap);
			for(String s : hmap.keySet()) {
				System.out.println(hmap.get(s).split("\\|")[0] + hmap.get(s).split("\\|")[1]);
			}
		} catch (Exception e) {

		}
	}
}