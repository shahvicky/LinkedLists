//
//public class LinkedListPalindrome {
//	
//}
//
//class LinkedList_ { 
//	Node_ root;
//	
//	public LinkedList_() {
//		
//	}
//	public LinkedList_(Node_ root) {
//		this.root = root;
//	}
//	public LinkedList_(int val) {
//		this.root.val = val;
//	}
//	
//	Node_ getRoot() {
//		return this.root;
//	}
//	
//	void addNode(Node_ node) {
//		if(root == null){
//			root = node;
//			return;
//		}
//		Node_ n = root;
//		while(n.next != null)
//			n = n.next;
//		n.next = node;
//		return;
//	}
//	
//	void printList(Node_ root) {
//		if(root == null)
//			return;
//		while(root!= null) {
//			System.out.print(root.val+" ");
//			root = root.next;
//		}
//		return;
//	}
//	
//}
//
//class Node_ {
//	int val;
//	Node_ next;
//	
//	public Node_(int val) {
//		this.val = val;
//	}
//}