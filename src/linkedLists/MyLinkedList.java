package linkedLists;

import linkedLists.StackImplemenation;

public class MyLinkedList {
	
	private Node head = null;
	private Node tail = null;
	private int listSize=0;
	
	public void traverse(){
		Node tmp = head;
		while(tmp != null){
			System.out.print(tmp.getData()+" ");
			tmp = tmp.getNext();
			if(tmp == null){
				break;
			}
		}
		System.out.println();
	}
	
	public void addNodeEnd(int data){
		Node nd = new Node();
		nd.setData(data);
		nd.setNext(null);
		//System.out.println("Adding node with data at end: "+ nd.getData());
		
		if(head == null){
			head = nd;
			tail = nd;
			listSize++;
		} else {
			tail.setNext(nd);
			tail = nd;
			listSize++;
		}
	}
	
	public void addNodeStart(int data){
		Node nd = new Node();
		nd.setData(data);
		nd.setNext(null);
		//System.out.println("Adding node with data at start: "+ nd.getData());
		
		if(head == null){
			head = nd;
			tail = nd;
			listSize++;
		} else {
			nd.setNext(head);
			head = nd;
			listSize++;
		}
	}
	
	public void delete(int data){
		Node tmp = head;
		if(head == null){
			System.out.println("Node not found");
		}else if(head.getData() == data){
			head = head.getNext();
			listSize--;
		}
		else{	
			while(tmp.getNext() != null){
				if(tmp.getNext().getData() == data){
					tmp.setNext(tmp.getNext().getNext());
					listSize--;
					break;
				}
				tmp = tmp.getNext();				
			}
			if(tmp.getNext() == null){
				System.out.println("\nData not found");
			}
		}
	}
	
	public Node getHead(){
		return head;
	}
	
	public int getListSize(){
		return listSize;
	}
	
	//recursively print data in reverse order
	public void ReversePrint(Node head){
	    if(head == null){
	        return;
	    }
	    ReversePrint(head.getNext());
	    System.out.print(head.getData()+" ");
	}
	
	//Insert a node at nth position
	public void insertNth(Node head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method.
		    Node tmp = head;
		    Node nd = new Node();
		    nd.setData(data);
		    int count = 0;
		    if(position == 0){
		        if(head == null){
		            head = nd;
		        } else {
		           nd.setNext(head);
		            head = nd;
		        } 
		    } else{
		        while(count != position-1){
		            tmp = tmp.getNext();
		            count++;
		        }
		        nd.setNext(tmp.getNext());
		        tmp.setNext(nd);
		    }
		    System.out.println("Insterted " + data+ " at position " + position);
		}
	
	// reverse the linked list
	public void reverse(Node head) {
	    Node curr = head;
	    Node prev = null;
	    Node next = null;
	    
	    if(curr == null){
	        return;
	    }
	    
	    while(curr.getNext() != null){
	        next = curr.getNext();
	        curr.setNext(prev);
	        prev = curr;
	        curr = next;
	    }
	    curr.setNext(prev);
	    this.head = curr;
	    return;
	}
	
	
	/*bring odd numbers in front
	input: 1->4->6->5->7->8->Null
	output: 1->5->7->4->6->8->Null*/
	public void oddEven(Node head) throws Exception{
		StackImplemenation stack = new StackImplemenation(100);
		Node curr = head;
		Node prev = null;
		Node next = null;
			
	
		if(curr == null || curr.getNext() == null){
			return;
		}else {
			while(curr != null){
				next = curr.getNext();
				if(curr == this.head){
					if(curr.getData()%2 != 0){
						this.head = next;
						stack.push(curr.getData());
						curr = next;
					}else{
						prev = curr;
						curr = next;
					}
				}else{
					if(curr.getData()%2 != 0 ){
							prev.setNext(curr.getNext());
							stack.push(curr.getData());
							curr = next;
					}else{
						prev = curr;
						curr = next;
					}
				}
				
			}
			
			while(!stack.isStackEmpty()){
				addNodeStart(stack.pop());
			}
			
		}
	}


	
}
