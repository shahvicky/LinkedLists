
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
public class Prims {
	public static void main (String[] args){
		
		char[] vertices = {'a','b','c','d','e','f','g','h','i','j','k','l'};
		
	 	PrimsTest graph = new PrimsTest(vertices);
		graph.createEdge('a','b',16);
		graph.createEdge('a','c',1);
		graph.createEdge('a','d',3);
		graph.createEdge('b','c',2);
		graph.createEdge('b','e',5);
		graph.createEdge('b','f',8);
		graph.createEdge('c','f',10);
		graph.createEdge('d','g',7);
		graph.createEdge('d','h',14);
		graph.createEdge('e','h',10);
		graph.createEdge('e','i',11);
		graph.createEdge('e','j',12);
		graph.createEdge('f','j',8);
		graph.createEdge('f','k',8);
		graph.createEdge('g','k',3);
		graph.createEdge('g','l',5);
		graph.createEdge('h','i',20);
		graph.createEdge('h','l',15);
		graph.createEdge('i','j',5);
		graph.createEdge('i','l',3);
		
		int[][] adjacencyMatrix = graph.show();
		System.out.println();
		System.out.println("************Weighted Adjacency Matrix***********");
		System.out.println();
		System.out.print("\t");
		for(int i=0; i<vertices.length; i++){
			System.out.print(vertices[i]+"\t");
		}
		System.out.println();
		int index = 0;
		for (int[] x : adjacencyMatrix)
		{
			System.out.print(vertices[index++]+"\t");
		   for (int y : x)
		   {
		        System.out.print(y + "\t");
		   }
		   System.out.println();
		}
		System.out.println();
		graph.primsTree(adjacencyMatrix, vertices.length);
	}
}
*/


class PrimsTest {
	
	private int noOfVertices;
	private char[] vertices;
	private int[][] adjacencyMatrix;
	
	public PrimsTest(char[] verticesArray){
		this.noOfVertices = verticesArray.length;
		vertices = new char[noOfVertices];
		for(int i=0; i<noOfVertices; i++){
			vertices[i] = verticesArray[i];
		}
		this.adjacencyMatrix = new int[noOfVertices][noOfVertices];
	}
	
	public void createEdge(char fromVertex, char toVertex, int weight){
		int from=-1,to=-1; 
		for(int i=0; i<this.vertices.length; i++){
			if(this.vertices[i] == fromVertex){
				from = i;
			}else if(this.vertices[i] == toVertex){
				to = i;
			}
		}
		if(from<0 || to<0){
			System.out.println("The vertices does not exist");
			return;
		}
		adjacencyMatrix[from][to] = weight;
		adjacencyMatrix[to][from] = weight;
	}
	
	public int[][] show(){
		return adjacencyMatrix;
	}
	
	private int minKey(int[] key, Boolean[] treeSet, int n){
		int min = Integer.MAX_VALUE, minIndex=-1;
	    for (int v = 0; v < n; v++){
	    	if (treeSet[v] == false && key[v] < min){
	            min = key[v];
	            minIndex = v;
	         }
	    }
	    return minIndex;
	 }

	 private void printTree(int[] parent, int n, int[][] graph){
	     System.out.println("Edges\tWeights");
	     for (int i = 1; i < n; i++)
	         System.out.println("("+this.vertices[parent[i]]+","+ this.vertices[i]+")"+"\t"+
	                            graph[i][parent[i]]);
	 }

	 public void primsTree(int[][] graph, int n){
	     int[] parentList = new int[n];
	     int[] key = new int[n];
	     Boolean treeList[] = new Boolean[n];
	     for (int i = 0; i < n; i++)
	     {
	         key[i] = Integer.MAX_VALUE;
	         treeList[i] = false;
	     }
	     key[0] = 0;     
	     parentList[0] = -1; 
	     for (int count = 0; count < n-1; count++){
	         int u = minKey(key, treeList, n);
	         treeList[u] = true;
	         for (int v = 0; v < n; v++)
	             if ((graph[u][v]!=0 && treeList[v] == false) && (graph[u][v] < key[v])){
	            	 parentList[v]  = u;
	                 key[v] = graph[u][v];
	             }
	     }
	     printTree(parentList, n, graph);
	 }
}

