/**
 * 
 */
package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 * @author limca
 *
 */

public class DFSandBFS {

	static class Graph {
		int V;
		LinkedList<Integer> adj[];

		Graph(int v) {

			this.V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}

		void addEdge(int src, int dest) {

			this.adj[src].add(dest);
			// this.adj[dest].add(src);
		}

		// A utility function to print the adjacency list
		// representation of graph
		void printGraph() {
			for (int v = 0; v < this.V; v++) {
				System.out.println("Adjacency list of vertex " + v);
				System.out.print("head");
				for (Integer pCrawl : this.adj[v]) {
					System.out.print(" -> " + pCrawl);
				}
				System.out.println("\n");
			}
		}

		public void BFS(int s) {

			Queue<Integer> qu = new LinkedList<Integer>();

			boolean visited[] = new boolean[this.V];

			qu.add(s);
			visited[s] = true;
			System.out.println("BFS Traversal from Node->" + s);
			while (!qu.isEmpty()) {
				s = qu.poll();
				System.out.print(s + " ");

				ListIterator ls = this.adj[s].listIterator();
				while (ls.hasNext()) {
					int n = (int) ls.next();
					if (!visited[n]) {
						qu.add(n);
						visited[n] = true;
					}
				}
			}

		}

		public void DFS(int s) {
			
			boolean visited[]=new boolean[this.V];
			
			DFSUTIL(s,visited);
			
			
		}

		private void DFSUTIL(int s, boolean[] visited) {
			
			if(!visited[s]) {
				System.out.print(s+" ");
				visited[s]=true;
			}
			ListIterator ls=this.adj[s].listIterator();
			while(ls.hasNext()) {
				
				int n=(int)ls.next();
				if(!visited[n]) {
					DFSUTIL(n, visited);
				}
			}
			
		}

	}

	public DFSandBFS() {
		// TODO Auto-generated constructor stub
	}

	public void BFS(Graph grap, int v) {

		List<Integer> que = new LinkedList<Integer>();
		boolean visited[] = new boolean[v];

		que.add(grap.adj[0].poll());
		visited[v] = true;

		while (!que.isEmpty()) {

		}

	}

	public static void main(String[] args) {
		// create the graph given in above figure
		int V = 4;
		Graph g = new Graph(V);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		// print the adjacency list representation of
		// the above graph
		g.printGraph();

		g.BFS(2);
		System.out.println("DFS from node->2");
		g.DFS(2);

	}

}
