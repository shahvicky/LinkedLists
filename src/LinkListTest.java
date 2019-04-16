package linkedLists;

public class LinkListTest {

	public static void main(String[] args) throws Exception {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addNodeEnd(2);
		linkedList.addNodeEnd(1);
		linkedList.addNodeEnd(4);
		linkedList.addNodeEnd(5);
		linkedList.addNodeEnd(8);
		linkedList.addNodeEnd(-2);
		linkedList.addNodeEnd(15);
		linkedList.addNodeEnd(-8);
		linkedList.addNodeEnd(26);
		linkedList.addNodeEnd(3);
		//linkedList.traverse();
		//linkedList.insertNth(linkedList.getHead(), 25, 2);
		linkedList.traverse();
		/*Node hd = linkedList.reverse1(linkedList.getHead());
		System.out.println(hd.getData());
		linkedList.traverse();*/
		//linkedList.oddEven(linkedList.getHead());
		linkedList.sort(linkedList.getHead());
		linkedList.traverse();
		//System.out.println(linkedList.getListSize());

	}

}
