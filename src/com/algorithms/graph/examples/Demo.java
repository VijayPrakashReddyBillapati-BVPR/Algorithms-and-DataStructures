package com.algorithms.graph.examples;

public class Demo {

	public static void main(String[] args) {
		ShortestPath graph = new ShortestPath();
		graph.addEdge(0 , 1);
		graph.addEdge(1 , 2);
		graph.addEdge(2 , 3);
		graph.addEdge(3 , 5);
		graph.addEdge(5 , 6);
		graph.addEdge(4 , 5);
		graph.addEdge(0 , 4);
		graph.addEdge(3 , 4);
		
//		graph.addEdge(2 , 1);
		graph.printAdList();
		
//		graph.shortestPath(1);
		graph.shortestPath(1,6);
	}

}
