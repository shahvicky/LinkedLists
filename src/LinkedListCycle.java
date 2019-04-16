import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
	public static void main(String[] args) {
		LinkedList_ list = new LinkedList_();
		list.addNode(new Node_(5));
		list.addNode(new Node_(6));
		list.addNode(new Node_(4));
		list.addNode(new Node_(7));
		list.addNode(new Node_(10));
		list.addNode(new Node_(8));
		Node_ root = list.getRoot();
		//making cycle
		root.next.next.next.next.next.next = root.next;
//		Node_ root = list.getRoot();
////		root.next = root;
		
		//print to see cycle
//		for(int i=0; i<20; i++) {
//			System.out.print(root.val+" ");
//			root = root.next;
//		}
		boolean isCycle = detectCycle(list.getRoot());
		System.out.println(isCycle ? "Cycle Detected" : "No Cycle");
		Node_ cycleMeet = cycleNode(list.getRoot());
		System.out.println(cycleMeet == null ? "No Cycle" : cycleMeet.val);
		breakCycle(list.getRoot());
		System.out.println("Broken");
		list.printList(list.getRoot());
		
		
	}
	
	static boolean detectCycle(Node_ root) {
		Node_ start = root;
		Node_ ahead = null;
		if(start != null) {
			ahead = start.next;
		} else {
			return false;
		}
		 
		while(start != null && ahead != null) {
			if(start == ahead) {
				return true;
			}
			System.out.println(start.val+" "+ ahead.val);
			start = start.next;
			ahead = ahead.next.next;
		}
		return false;
	}
	
	static Node_ cycleNode(Node_ root) {
		Set<Node_> set = new HashSet<>();
		while(root != null) {
			set.add(root);
			root = root.next;
			if(set.contains(root)) {
				return root;
			}
		}
		return null;
	}
	
	static void breakCycle(Node_ root) {
		Set<Node_> set = new HashSet<>();
		if(root == null)
			return;
		set.add(root);
		while(root.next!= null) {
			if(set.contains(root.next)) {
				root.next = null;
				return;
			}
			root = root.next;
			set.add(root);
		}
		return;
	}
}

class LinkedList_ { 
	Node_ root;
	
	public LinkedList_() {
		
	}
	public LinkedList_(Node_ root) {
		this.root = root;
	}
	public LinkedList_(int val) {
		this.root.val = val;
	}
	
	Node_ getRoot() {
		return this.root;
	}
	
	void addNode(Node_ node) {
		if(root == null){
			root = node;
			return;
		}
		Node_ n = root;
		while(n.next != null)
			n = n.next;
		n.next = node;
		return;
	}
	
	void printList(Node_ root) {
		if(root == null)
			return;
		while(root!= null) {
			System.out.print(root.val+" ");
			root = root.next;
		}
		return;
	}
	
}

class Node_ {
	int val;
	Node_ next;
	
	public Node_(int val) {
		this.val = val;
	}
}
