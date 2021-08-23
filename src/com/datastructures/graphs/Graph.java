package com.datastructures.graphs;


//import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Graph<T> {
	Map<T, LinkedList<T>> graph;

	public Graph() {
		graph = new HashMap<T, LinkedList<T>>();
	}

	public Graph(List<T> edges) {
		graph = new HashMap<T, LinkedList<T>>();
		for (T key : edges) {
			graph.put(key, new LinkedList<T>());
		}

	}

	public void addEdge(T vertex1, T vertex2) {
		addEdge(vertex1, vertex2, false);
	}

	public void addEdge(T i, T j, boolean directed) {
		if (!findEdge(i))
			addVertex(i);

		graph.get(i).add(j);

		if (!directed) {
			if (!findEdge(j))
				addVertex(j);
			graph.get(j).add(i);
		}
	}

	private boolean findEdge(T i) {
		if (graph.containsKey(i))
			return true;
		return false;
	}

	void addVertex(T label) {
		graph.putIfAbsent(label, new LinkedList<>());
	}

	public void printAdList() {
		
		for (T vertex:graph.keySet()) {
			System.out.print(vertex + " --> ");
			for (T edge : graph.get(vertex)) {
				System.out.print(edge + ", ");
			}
			System.out.print("\n");

		}
	}

}

/**
 * 
 public class Graph<T> {
	Map<T, Node> graph;

	public Graph(List<T> edges) {
		graph = new HashMap<T, Node>();
		for (T key : edges) {
			graph.put(key, new Node(key));
		}

	}

	public Graph() {
		graph = new HashMap<T, Node>();
	}

	public void addEdge(T vertex1, T vertex2) {
		addEdge(vertex1, vertex2, false);
	}

	public void addEdge(T vertex1, T vertex2, boolean directed) {
		if (!findEdge(vertex1))
			addVertex(vertex1);

		graph.get(vertex1).list.add(vertex2);

		if (!directed) {
			if (!findEdge(vertex2))
				addVertex(vertex2);
			graph.get(vertex2).list.add(vertex1);
		}
	}

	void addVertex(T label) {
		graph.putIfAbsent(label, new Node(label));
	}

	private boolean findEdge(T key) {
		if (graph.containsKey(key))
			return true;
		return false;
	}

	public void printAdList() {
		System.out.println("printAdList");
		for (T vertex : graph.keySet()) {
			System.out.print(graph.get(vertex).key + " --> ");
			for (T edge : graph.get(vertex).list) {
				System.out.print(edge + ", ");
			}
			System.out.print("\n");

		}
	}

	class Node {
		T key;
		List<T> list;

		public Node() {
			super();
			list = new ArrayList<T>();
		}

		public Node(T key) {
			super();
			this.key = key;
			list = new ArrayList<T>();
		}

	}
}
 * 
 */

/**
 * 
 public class Graph {
	int vertices;
	ArrayList<LinkedList<Integer>> graph;

	public Graph(int number_vertices) {
		this.vertices = number_vertices;
		graph = new ArrayList<LinkedList<Integer>>(number_vertices);
		for (int i = 0; i < vertices; i++) {
			graph.add(i, new LinkedList<Integer>());
		}
	}

	public void addEdge(int vertex1, int vertex2) {
		addEdge(vertex1, vertex2, false);
	}

	public void addEdge(int i, int j, boolean directed) {
		graph.get(i).add(j);

		if (!directed) {
			graph.get(j).add(i);
		}
	}

	public void printAdList() {
		for (int i = 0; i < vertices; i++) {
			System.out.print(i + " --> ");
			for (Integer vertex : graph.get(i)) {
				System.out.print(vertex + ", ");
			}
			System.out.print("\n");
		}
	}
}
 
 *
 */
