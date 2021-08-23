package com.datastructures.graphs;


public class GraphDemo {

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<Integer>();
		graph.addEdge(0 , 1);
		graph.addEdge(0 , 4);
		graph.addEdge(2 , 1);
		graph.addEdge(3 , 4);
		graph.addEdge(4 , 5);
		graph.addEdge(2 , 3);
		graph.addEdge(3 , 5);
		graph.printAdList();
		
		
		
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
