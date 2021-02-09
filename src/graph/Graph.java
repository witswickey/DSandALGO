package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	private List<Edge<T>> allEdges;
	private Map<Long, Vertex<T>> allVertex;
	boolean isDirected = false;

	public Graph(boolean isDirected) {
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Long, Vertex<T>>();
		this.isDirected = isDirected;
	}

	public void addVertex(Vertex<T> vertex) {
		if (allVertex.containsKey(vertex.getId())) {
			return;
		}
		allVertex.put(vertex.getId(), vertex);
		for (Edge<T> edge : vertex.getEdges()) {
			allEdges.add(edge);
		}
	}

	public Vertex<T> addSingleVertex(long id) {
		if (allVertex.containsKey(id)) {
			return allVertex.get(id);
		}
		Vertex<T> v = new Vertex<T>(id);
		allVertex.put(id, v);
		return v;
	}

	public Vertex<T> getVertex(long id) {
		return allVertex.get(id);
	}

	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}

	private void addEdge(long id1, long id2, int w) {

		Vertex<T> v1, v2;
		if (!allVertex.containsKey(id1)) {
			v1 = new Vertex<T>(id1);
			allVertex.put(id1, v1);
		} else {
			v1 = allVertex.get(id1);
		}
		if (!allVertex.containsKey(id2)) {
			v2 = new Vertex<T>(id2);
			allVertex.put(id2, v2);
		} else {
			v2 = allVertex.get(id2);
		}

		Edge<T> edge = new Edge(v1, v2, isDirected, w);
		allEdges.add(edge);
		v1.addAdjacentVertex(edge, v2);
		if (!isDirected) {
			v2.addAdjacentVertex(edge, v1);
		}

	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	public Collection<Vertex<T>> getAllVertex() {
		return allVertex.values();
	}

	public void setDataForVertex(long id, T data) {
		if (allVertex.containsKey(id)) {
			Vertex<T> vertex = allVertex.get(id);
			vertex.setData(data);
		}
	}

}

class Vertex<T> {
	T data;
	long id;
	private List<Edge<T>> edges = new ArrayList<>();
	private List<Vertex<T>> adjacentVertex = new ArrayList<>();

	Vertex(long id) {
		this.id = id;
	}

	public List<Edge<T>> getEdges() {
		return this.edges;
	}

	public void addAdjacentVertex(Edge<T> edge, Vertex<T> v2) {

		this.edges.add(edge);
		this.adjacentVertex.add(v2);

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex<T> other = (Vertex<T>) obj;
		if (id != other.id)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}

class Edge<T> {

	public Edge(Vertex<T> vertexS, Vertex<T> vertexD, boolean isDirected, int w) {
		super();
		this.vertexS = vertexS;
		this.vertexD = vertexD;
		this.isDirected = isDirected;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Edge [vertexS=" + vertexS + ", vertexD=" + vertexD + ", isDirected=" + isDirected + ", w=" + w + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isDirected ? 1231 : 1237);
		result = prime * result + ((vertexD == null) ? 0 : vertexD.hashCode());
		result = prime * result + ((vertexS == null) ? 0 : vertexS.hashCode());
		result = prime * result + w;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge<T> other = (Edge<T>) obj;
		if (vertexD == null) {
			if (other.vertexD != null)
				return false;
		} else if (!vertexD.equals(other.vertexD))
			return false;
		if (vertexS == null) {
			if (other.vertexS != null)
				return false;
		} else if (!vertexS.equals(other.vertexS))
			return false;
		if (w != other.w)
			return false;
		return true;
	}

	public Vertex<T> getVertexS() {
		return vertexS;
	}

	public void setVertexS(Vertex<T> vertexS) {
		this.vertexS = vertexS;
	}

	public Vertex<T> getVertexD() {
		return vertexD;
	}

	public void setVertexD(Vertex<T> vertexD) {
		this.vertexD = vertexD;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	Vertex<T> vertexS;
	Vertex<T> vertexD;
	boolean isDirected;
	int w;
}