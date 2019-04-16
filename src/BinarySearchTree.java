import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//New class = BinarySearchTree
public class BinarySearchTree{
//Defining Node
	class Node
    {
        int val;
        Node left;
        Node right;
        public Node(int key)
        {
            val=key;
            left=right=null;
        }
    }
    Node root;
// Constructor for BinarySearchTree
    BinarySearchTree()
    {
        root=null;
    }
    
// Calling function insertNode
    void insertNode(int nodeVal)
    {
        root=insertNode(root,nodeVal);
    }
    
// Extension to find the node to insert
    Node insertNode(Node node,int nodeVal)
    {
        if(node==null)
        {
        	node=new Node(nodeVal);
        	return node;
        }
        if(nodeVal<node.val)
        {
        	node.left= insertNode(node.left,nodeVal);
        }
        else if(nodeVal>node.val)
        {
        	node.right = insertNode(node.right,nodeVal);
        }
        return node;
    }
    
 // Function call to delete the node
    void deleteKey(int nodeVal)
    {
        root = deleteRec(root, nodeVal);
    }
 
// Extension to find the node to delete and finding successor
    Node deleteRec(Node node, int nodeVal)
    {
        if (node == null)  return node;
 
        if (nodeVal < node.val)
            node.left = deleteRec(node.left, nodeVal);
        else if (nodeVal > node.val)
            node.right = deleteRec(node.right, nodeVal);
 
        else
        {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
 
            node.val = minValue(node.right);

            node.right = deleteRec(node.right, node.val);
        }
 
        return node;
    }
    
 // Function to align the tree in inorder format
    void inorder()  
     {
       inorderRec(root);
     }

 // Algorithm to align the tree in inorder format
    void inorderRec(Node node) 
    {
        if (node != null) 
        {
            inorderRec(node.left);
            System.out.print(node.val+" ");
            inorderRec(node.right);
        }
    
    }
// finding the minvalue to return the successor
    int minValue(Node node)
    {
        int minv = node.val;
        while (node.left != null)
        {
            minv = node.left.val;
            node = node.left;
        }
        return minv;
    }
    public static void main(String[] args) 
    {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scan=new Scanner(System.in);
        
 //Userinput to enter the number of nodes,
        int Userinput,DelEle,NewEle;
        do 
        {
        	System.out.println("Please enter value greater than 0!");
        	while (!scan.hasNextInt()) 
        	{
        		System.out.println("That's not a number!");
        		scan.next(); // this is important!
        	}
        	Userinput = scan.nextInt();
        } while (Userinput <= 0);
        int a[]= new int[Userinput];
        int k = 0;
        int l,i=0;
        System.out.println("Thank you! Now you have to input " + Userinput + " number of node values.");
        do {
        NewEle =scan.nextInt();
        for(int j=0;j<Userinput;j++)
        	{if(NewEle==a[j])
        	{
        		k=1;
        		System.out.println("Element present. Please enter another element");}
        	}
        	if(k==0)
        		{ a[i]=NewEle;
            	tree.insertNode(NewEle);
            	i++;}
        		k=0;
        		
        		
        }while(i!=Userinput);
        
        
        System.out.println("Tree inorder before deleting");
        tree.inorder();
        System.out.println('\n');
        System.out.print("Root of the tree:");
        System.out.println(tree.root.val);
        
        
        do 
        {
        	System.out.println("Please enter value to delete!");
        	while (!scan.hasNextInt()) 
        	{
        		System.out.println("That's not a number!");
        		scan.next(); // this is important!
        	}
        	DelEle = scan.nextInt();
        } while (DelEle <= 0);
        tree.deleteKey(DelEle);
        
        System.out.println("Tree inorder after deleting");
        tree.inorder();
        System.out.println('\n');
        System.out.println("Root of the tree:");
        System.out.print(tree.root.val);
    }
}