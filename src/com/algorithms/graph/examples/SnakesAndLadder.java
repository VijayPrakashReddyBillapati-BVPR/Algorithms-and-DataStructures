package com.algorithms.graph.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.datastructures.queue.Queue;

public class SnakesAndLadder {
	
	Map<Integer, LinkedList<Integer>> graph;

	public SnakesAndLadder(int vertices) {
		graph = new HashMap<Integer, LinkedList<Integer>>();
		for(int i=0; i<vertices; i++)
		{
			graph.put(i, new LinkedList<Integer>());
		}
	}

	public SnakesAndLadder(List<Integer> edges) {
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
	
	public int minCostBSF(int source, int destination)
	{
		Queue<Integer> queue = new Queue<Integer>();
		boolean[] visited =  new boolean[graph.size()];
		Arrays.fill(visited, false);
		
		int distance[] =  new int[graph.size()];
		Arrays.fill(distance, 0);
		
		queue.enqueue(source);
		distance[source] = 0;
		visited[source] = true;
		
		while(!queue.isEmpty())
		{
			int start = queue.dequeue();
			for(Integer neighbour: graph.get(start))
			{
				if(!visited[neighbour])
				{
					queue.enqueue(neighbour);
					visited[neighbour] = true;
					distance[neighbour] = distance[start]+1;
				}
			}
		}
		return distance[destination];
	}

		
	public int min_die_throws(Integer n,Map<Integer, Integer> snakes, Map<Integer, Integer> ladders)
	{		
		int[] board =  new int[graph.size()];
		Arrays.fill(board, 0);
		
		for(Integer snake: snakes.keySet())
		{
			Integer head = snake;
			Integer tail = snakes.get(snake);
			board[head] = tail-head;
		}
		
		for(Integer ladder: ladders.keySet())
		{
			Integer head = ladder;
			Integer tail = snakes.get(ladder);
			board[head] = tail-head;
		}
		
		
		SnakesAndLadder g =  new SnakesAndLadder(n+1);
		for(int i=0; i< n; i++)
		{
			for(int dice=1;dice<=6;dice++)
			{
				int vertex = i+dice;
				vertex+=board[vertex];
				if(vertex<=n)
					g.addEdge(i, vertex);
			}
		}
		return minCostBSF(1,n);
		
	}



}
