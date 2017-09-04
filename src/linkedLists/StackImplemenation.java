package linkedLists;

public class StackImplemenation {
	
	private int[] stackArr;
	private int stackSize;
	private int top;
	
	public int[] getStack() {
		int[] arr = new int[top+1];
		for(int i=0; i<=top; i++){
			arr[i] = stackArr[i];
		}
		return arr;
	}
	
	//constructor to create stack with stacksize as size 
	public StackImplemenation(int size){
		this.stackSize = size;
		this.stackArr = new int[stackSize];
		this.top = -1;
		
	}
	
	public boolean isStackEmpty(){
		if(this.top>-1){
			return false;
		}
		return true;
	}
	
	public boolean isStackFull(){
		if(this.top == this.stackSize-1){
			return true;
		}
		return false;
	}
	
	public int pop() throws Exception{
		
		if(!isStackEmpty()){
			int value = stackArr[top];
			top--;
			return value;
		}else{
			throw new Exception("Stack empty, can't pop");
		}
	}
	
	public void push(int data) throws Exception{
		if(!isStackFull()){
			top++;
			stackArr[top] = data;
		}else{
			throw new Exception("Stack full, can't push");
		}
	}
	
	public int getLast(){
		return stackArr[top];
	}
	
	
}
