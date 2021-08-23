package com.algorithms.searching.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DepthFirstSearch<T> {

	Map<T, LinkedList<T>> graph;

	public DepthFirstSearch() {
		super();
		graph = new HashMap<T, LinkedList<T>>();
	}

	public void addEdge(T old_vertex, T new_vertex) {
		addEdge(old_vertex, new_vertex, false);
	}

	public void addEdge(T old_vertex, T new_vertex, boolean directed) {
		if (!graph.containsKey(old_vertex))
			addVertex(old_vertex);
		graph.get(old_vertex).add(new_vertex);

		if (!directed) {
			if (!graph.containsKey(new_vertex))
				addVertex(new_vertex);
			graph.get(new_vertex).add(old_vertex);
		}
	}

	private void addVertex(T old_vertex) {
		graph.putIfAbsent(old_vertex, new LinkedList<T>());

	}

	public void depthFirstSearch(Integer startPoint) {

		boolean[] visited = new boolean[graph.size()];
		Arrays.fill(visited, false);
		dfsHelper(startPoint, visited);
	}

	private void dfsHelper(Integer startPoint, boolean[] visited) {
		visited[startPoint] = true;
		System.out.print(startPoint);
		for (T vertex : graph.get(startPoint)) {
			if (!visited[(int) vertex]) {
				visited[(int) vertex] = true;
				System.out.print(" -> ");
				dfsHelper((Integer) vertex, visited);
			}
		}

	}

}
