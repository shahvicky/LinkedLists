package linkedLists;

public class LinkListTest {

	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addNodeEnd(10);
		linkedList.addNodeStart(5);
		linkedList.addNodeStart(14);
		linkedList.addNodeEnd(17);
		linkedList.traverse();
		linkedList.InsertNth(linkedList.getHead(), 25, 2);
		linkedList.traverse();
		linkedList.Reverse(linkedList.getHead());
		linkedList.traverse();
		//System.out.println(linkedList.getListSize());

	}

}
