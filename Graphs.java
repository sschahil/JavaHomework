import java.util.ArrayList;
import java.util.HashMap;

public class Graphs<V>{
	
	private HashMap<V, ArrayList<Edge<V>>> adjacencyList;
	
	private ArrayList<V> vertexList;
	private boolean directed;
	
	public Graphs(boolean isDirected) {
		directed = isDirected;
		adjacencyList = new HashMap<V, ArrayList<Edge<V>>>();
		vertexList = new ArrayList<V>();
	}//end of Constructor
	
	public void add(V vertex, ArrayList<Edge<V>> connectedVerticies) {
		adjacencyList.put(vertex, connectedVerticies);
		vertexList.add(vertex);
		
		for(Edge<V> vertexConnectedToAddedVertex : connectedVerticies) {
			ArrayList<Edge<V>> correspondingConnectedList = adjacencyList.get(vertexConnectedToAddedVertex.getVertex());
			if(correspondingConnectedList == null) {
				adjacencyList.put(vertexConnectedToAddedVertex.getVertex(), new ArrayList<Edge<V>>());
				vertexList.add(vertexConnectedToAddedVertex.getVertex());
				correspondingConnectedList = adjacencyList.get(vertexConnectedToAddedVertex.getVertex());
			}
			
			if(!directed) {
				int weight = vertexConnectedToAddedVertex.getWeight();
				correspondingConnectedList.add(new Edge<V>(vertex,weight));
			}
		}//end of for loop
	}//end of method add
	
	public boolean addArc(V source, V end, int weight) {
		if(!directed) {
			return false;
		}
		
		if(!adjacencyList.containsKey(source)) {
			ArrayList<Edge<V>> tempList = new ArrayList<Edge<V>>();
			tempList.add(new Edge<V>(end, weight));
			add(source, tempList);
			return true;
		}
		
		if(!adjacencyList.containsKey(end)) {
			ArrayList<Edge<V>> tempList = new ArrayList<Edge<V>>();
			add(end, tempList);
		}
		
		adjacencyList.get(source).add(new Edge<V>(end, weight));
		return true;
	}//end of method addArc
	
	public boolean addEdge(V vertexOne, V vertexTwo, int weight) {
		if(directed) {
			return false;
		}
		
		if(!adjacencyList.containsKey(vertexOne)) {
			ArrayList<Edge<V>> tempList = new ArrayList<Edge<V>>();
			tempList.add(new Edge<V>(vertexTwo, weight));
			add(vertexOne, tempList);
			return true;
		}
		
		if(!adjacencyList.containsKey(vertexTwo)) {
			ArrayList<Edge<V>> tempList = new ArrayList<Edge<V>>();
			tempList.add(new Edge<V>(vertexOne, weight));
			add(vertexTwo, tempList);
			return true;
		}
		
		adjacencyList.get(vertexOne).add(new Edge<V>(vertexTwo, weight));
		adjacencyList.get(vertexTwo).add(new Edge<V>(vertexOne, weight));
		return true;
	}//end of method addEdge
	
	public ArrayList<V> getAdjacentVerticies(V vertex) {
		ArrayList<V> returnList = new ArrayList<V>();
		for(Edge<V> edge : adjacencyList.get(vertex)) {
			returnList.add(edge.getVertex());
		}
		return returnList;
	}//end of method getAdjacentVerticies
	
	public double getDistanceBetween(V source, V end) {
		for(Edge<V> edge : adjacencyList.get(source)) {
			if(edge.getVertex() == end) {
				return edge.getWeight();
			}
		}
		return Double.POSITIVE_INFINITY;
	}//end of method getDistanceBetween
	
	public ArrayList<V> getVertexList() {
		return vertexList;
	}
	
	public String toString() {
		String s = "";
		for(V vertex : vertexList) {
			s += vertex.toString();
			s += " : ";
			s += adjacencyList.get(vertex);
			s += "\n";
		}
		return s;
	}//end of method toString
}//end of class Graphs

class Edge<V> {
	private V vertex;
	private int weight;
	
	public Edge(V vert, int w) {
		vertex = vert;
		weight = w;
	}
	
	public V getVertex() {
		return vertex;
	}
	
	public void setVertext(V vertex) {
		this.vertex = vertex;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return "(" + vertex + ", " + weight + ")";
	}
}
