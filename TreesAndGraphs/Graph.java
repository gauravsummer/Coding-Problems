package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private Node[] nodes;
	private ArrayList<String, int[]> adjs;
	public Graph(Node[] nodes, ArrayList<Node, Node[]> adjacency) {
		this.nodes = nodes;
		this.adj = adjacency;
	}
	
	class Node {
		private String name;
		public Node(String name) {
			this.name = name;
		}
		public Node[] children;
	}
	Node node1 = new Node("1");
	Node node2 = new Node("2");
	Node node3 = new Node("3");
	Node node4 = new Node("4");
	Node[] nods = {node1, node2, node3, node4, node5, node6, node7};
	Arrayist<Node, Node[]> adj = new ArrayList<Node, Node[]>();
	Graph g1 = new Graph();
	g1.nodes = nods;
}
