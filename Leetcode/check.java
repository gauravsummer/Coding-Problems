package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class check {
	

private static ArrayList<Integer[]> edges; 
private static int[][] residual;
private static int noOfVertex = 0;
private static int noOfEdges = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		noOfVertex = scan.nextInt();
		noOfEdges = scan.nextInt();
		 
////////Initialize adjacency matrix(residual) to -1////////////////	
		residual = new int[noOfVertex][noOfVertex];
		for(int i=0; i<noOfVertex; i++) {
			for(int j=0; j<noOfVertex; j++) {
				residual[i][j] = -1;
			}
		}
		
//Updating egdes for residual matrix with edge weight and adding reverse edges//////		
		edges = new ArrayList<Integer[]>();
		for(int i=0; i<noOfEdges; i++) {
				int src = scan.nextInt();
				int dest = scan.nextInt();
				int weight = scan.nextInt();
				Integer[] edge = {src,dest};
				edges.add(edge);
				residual[src][dest] = weight;
				residual[dest][src] = 0;
		}
		
////calling function to update edge weights beased on shortest path to sink//// 
		bfs();
		
////calling function to print the output///////////////////////////////////////		
		printOutput();
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] pred = new int[noOfEdges];;
		String[] color = new String[noOfEdges]; 
		boolean pathFound = true;
		while(pathFound) {
			pathFound = false;
			Stack<Integer> stack = new Stack<Integer>();
			ArrayList<Integer> path = new ArrayList<Integer>();
			for(int i=0; i<noOfVertex; i++) {
				pred[i] = -1;
				color[i] = "WHITE";
			}
			color[0] = "GREY";
			queue.clear();
			queue.add(0);
			while(queue.size() != 0) {
				int u = queue.remove();
				//// if the search reaches the sink, update the flag/////
				if(u == 1)
					pathFound = true;
				
				/// bfs traversal only when edge can transfer commodity to the sink//
				for(int j=0; j<noOfVertex; j++) {
					if(residual[u][j] > 0 && u != 1) {
						if(color[j].equals("WHITE")) {
							color[j] = "GREY";
							pred[j] = u;
							queue.add(j);
						}
					}
				}
				color[u] = "BLACK";
			}
			
			// if a path from source to sink is found, add vertices to the stack//
			if(pathFound) {
				// add sink///////
				stack.add(1);
				// add predecessor vertices of this path till the source/////
				for(int i = 1; i != 0;) {
					stack.add(pred[i]);
					i = pred[i];
				}
			}
			
			// add vertices of the path from source-sink to an arraylist(path)////////
			int k = stack.size();
			for(int j=0; j<k; j++) {
				path.add(stack.pop());
			}
			
			////updating critical edge weight for the path////////
			int criticalWeight = 100000;
			for(int i=0; i<path.size()-1; i++) {
				int edgeWeight = residual[path.get(i)][path.get(i+1)];
				if(edgeWeight < criticalWeight)
					criticalWeight = edgeWeight;
			}
			
			////update edge weight and reverse edge weight in residual matrix////
			for(int i=0; i<path.size()-1; i++) {
				residual[path.get(i)][path.get(i+1)] = residual[path.get(i)][path.get(i+1)] - criticalWeight;
				residual[path.get(i+1)][path.get(i)] = residual[path.get(i+1)][path.get(i)] + criticalWeight;
			}
		}
	}
	
///////Function to print output//////////////////////////////////////////////	
	public static void printOutput() {
		int maxFlow = 0;
	///// adding columns of the residual matrix row that corresponds to the sink//
		for(int i=0; i<noOfVertex; i++) {
			if(residual[1][i] != -1)
				maxFlow = maxFlow + residual[1][i];
		}
		System.out.println(maxFlow);
	//// print maximum flow for each edge//////////////////////////////////////	
		for(Integer[] i : edges) {
			for(int j=0; j<2; j++) {
				System.out.print(i[j]+" ");
			}
			////just print the weight of the reverse edge///////////////////////
			System.out.print(residual[i[1]][i[0]]);
			System.out.println();
		}
	}
}
