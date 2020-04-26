package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphBasic {
	
	static class Graph{
		int V;
	    LinkedList<Integer> adj[];
	    
	    Graph(int v){
	    	
	    	this.V=v;
	    	adj=new LinkedList[v];
	    	for(int i=0;i<v;i++) {
	    		adj[i]=new LinkedList();
	    	}
	    }

	}
    static void addEdge(Graph gap,int src, int dest) {
    	
    	gap.adj[src].add(dest);
    	gap.adj[dest].add(src);
    }

    // A utility function to print the adjacency list  
    // representation of graph 
    static void printGraph(Graph graph) 
    {        
        for(int v = 0; v < graph.V; v++) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for(Integer pCrawl: graph.adj[v]){ 
                System.out.print(" -> "+pCrawl); 
            } 
            System.out.println("\n"); 
        } 
    } 
    
	public GraphBasic() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// create the graph given in above figure 
        int V = 5; 
        Graph graph = new Graph(V); 
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        printGraph(graph); 

	}

}
