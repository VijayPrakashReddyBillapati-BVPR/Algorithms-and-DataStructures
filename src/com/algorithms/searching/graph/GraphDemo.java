package com.algorithms.searching.graph;


public class GraphDemo {

	public static void main(String[] args) {
//		BreathFirstSearch graph = new BreathFirstSearch();
		DepthFirstSearch<Integer> graph = new DepthFirstSearch<Integer>();
		graph.addEdge(0 , 1);
		graph.addEdge(1 , 2);
		graph.addEdge(2 , 3);
		graph.addEdge(3 , 5);
		graph.addEdge(5 , 6);
		graph.addEdge(4 , 5);
		graph.addEdge(0 , 4);
		graph.addEdge(3 , 4);
		
		
//		graph.addEdge(2 , 1);
		
//		graph.breathFirstSearch(1);
		
		graph.depthFirstSearch(1);
//		graph.printAdList();
		
		
		
		/**
		Graph graph = new Graph(6);
		graph.addEdge(0 , 1);
		graph.addEdge(0 , 4);
		graph.addEdge(2 , 1);
		graph.addEdge(3 , 4);
		graph.addEdge(4 , 5);
		graph.addEdge(2 , 3);
		graph.addEdge(3 , 5);
		graph.printAdList();
		 */
		
		/**
		 
		 Graph<String> graph = new Graph<String>();
		graph.addEdge("Delhi","Landon");
		graph.addEdge("New York","Landon");
		graph.addEdge("Delhi","Paris");
		graph.addEdge("Paris","New York");
		graph.printAdList();
		
		 */
	}

}
