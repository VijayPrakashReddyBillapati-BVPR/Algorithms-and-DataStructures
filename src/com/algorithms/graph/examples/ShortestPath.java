package com.algorithms.graph.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.datastructures.queue.Queue;

public class ShortestPath {
	
	Map<Integer, LinkedList<Integer>> graph;

	public ShortestPath() {
		graph = new HashMap<Integer, LinkedList<Integer>>();
	}

	public ShortestPath(List<Integer> edges) {
		graph = new HashMap<Integer, LinkedList<Integer>>();
		for (Integer key : edges) {
			graph.put(key, new LinkedList<Integer>());
		}

	}

	public void addEdge(Integer vertex1, Integer vertex2) {
		addEdge(vertex1, vertex2, false);
	}

	public void addEdge(Integer i, Integer j, boolean directed) {
		if (!findEdge(i))
			addVertex(i);

		graph.get(i).add(j);

		if (!directed) {
			if (!findEdge(j))
				addVertex(j);
			graph.get(j).add(i);
		}
	}

	private boolean findEdge(Integer i) {
		if (graph.containsKey(i))
			return true;
		return false;
	}

	void addVertex(Integer label) {
		graph.putIfAbsent(label, new LinkedList<>());
	}

	public void printAdList() {
		
		for (Integer vertex:graph.keySet()) {
			System.out.print(vertex + " --> ");
			for (Integer edge : graph.get(vertex)) {
				System.out.print(edge + ", ");
			}
			System.out.print("\n");

		}
	}
	
	public void breathFirstSearch(Integer startNode)
	{
		Queue<Integer> queue = new Queue<Integer>();
		boolean[] visited =  new boolean[graph.size()];
		Arrays.fill(visited, false);
		
		int[] distance =  new int[graph.size()];
		Arrays.fill(distance, 0);
		
		int[] parent =  new int[graph.size()];
		Arrays.fill(parent, -1);
		
		queue.enqueue(startNode);
		visited[startNode] = true;
		parent[startNode] = startNode;
		distance[startNode] = 0;
		
		while(!queue.isEmpty())
		{
			Integer current = queue.dequeue();
			System.out.print(" -> "+current);
			
			for(Integer neighbour:graph.get(current))
			{
				if(!visited[neighbour])
				{
					queue.enqueue(neighbour);
					
					parent[neighbour] = current;
					distance[neighbour] = distance[current]+1;
					visited[neighbour] = true;
				}
			}
		}		
		
		System.out.println("\n");
		for(int i=0; i< distance.length;i++)
		{
			System.out.println("Shortest Distance to "+ i+" is "+distance[i]);
		}
		
	}

	public void breathFirstSearch(Integer startNode, int dest)
	{
		Queue<Integer> queue = new Queue<Integer>();
		boolean[] visited =  new boolean[graph.size()];
		Arrays.fill(visited, false);
		
		int[] distance =  new int[graph.size()];
		Arrays.fill(distance, 0);
		
		int[] parent =  new int[graph.size()];
		Arrays.fill(parent, -1);
		
		queue.enqueue(startNode);
		visited[startNode] = true;
		parent[startNode] = startNode;
		distance[startNode] = 0;
		
		while(!queue.isEmpty())
		{
			Integer current = queue.dequeue();
			System.out.print(" -> "+current);
			
			for(Integer neighbour:graph.get(current))
			{
				if(!visited[neighbour])
				{
					queue.enqueue(neighbour);
					
					parent[neighbour] = current;
					distance[neighbour] = distance[current]+1;
					visited[neighbour] = true;
				}
			}
		}		
		
		System.out.println("\n");
		for(int i=0; i< distance.length;i++)
		{
			System.out.println("Shortest Distance to "+ i+" is "+distance[i]);
		}
		
		System.out.println("\n");
		if(dest!=-1)
		{
			int temp = dest;
			while(temp!=startNode)
			{
				System.out.print(temp+" <- ");
				temp=parent[temp];
			}
			System.out.print(startNode);
		}
	}


}
