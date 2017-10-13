package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class maxflow {

private static int[][] residualFlow;
private static ArrayList<Integer[]> edges;
private static int noOfVertex = 0;
private static int noOfEdges = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		noOfVertex = scan.nextInt();
		noOfEdges = scan.nextInt();
		
		/////Initialization////////////////////////////////////////////
		residualFlow = new int[noOfVertex][noOfVertex];
		for(int i=0; i<noOfVertex; i++) {
			for(int j=0; j<noOfVertex; j++) {
				residualFlow[i][j] = -1;
			}
		}
		edges = new ArrayList<Integer[]>(); 
		for(int i=0; i<noOfEdges; i++) {
				int src = scan.nextInt();
				int dest = scan.nextInt();
				Integer[] edge = {src,dest};
				edges.add(edge);
				int weight = scan.nextInt();
				residualFlow[src][dest] = weight;
				/////Back Edge with initial flow 0///////////////////////////////////
				residualFlow[dest][src] = 0;
		}
		scan.close();
		
		edmondsKarp();
		
		printOutput();
	}
	
	/////Edmond's Karp Algorithm to find Augmenting path and update edge flow//////////
	public static void edmondsKarp() {
		boolean pathFound = true;
		int[] pred = new int[noOfEdges];;
		String[] color = new String[noOfEdges];;
		while(pathFound) {
			pathFound = false;
			for(int i=0; i<noOfVertex; i++) {
				pred[i] = -1;
				color[i] = "WHITE";
			}
			color[0] = "GREY";
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(0);
			Stack<Integer> stack = new Stack<Integer>();
			ArrayList<Integer> Augpath = new ArrayList<Integer>();
			while(queue.size() != 0) {
				int u = queue.remove();
				/////If sink is reachable, set flag to true/////////////////////////
				if(u == 1)
					pathFound = true;
				for(int j=0; j<noOfVertex; j++) {
					if(residualFlow[u][j] > 0 && u != 1) {
						if(color[j].equals("WHITE")) {
							color[j] = "GREY";
							pred[j] = u;
							queue.add(j);
						}
					}
				}
				color[u] = "BLACK";
			}
			/////Put path vertex into list////////////////////////////////////////////
			if(pathFound) {
				stack.add(1);
				for(int i = 1; i != 0;) {
					stack.add(pred[i]);
					i = pred[i];
				}
			}
			int k = stack.size();
			for(int j=0; j<k; j++) {
				Augpath.add(stack.pop());
			}
			/////Find critical edge weight//////////////////////////////////////////
			int criticalWeight = 1111111;
			for(int i=0; i<Augpath.size()-1; i++) {
				if(residualFlow[Augpath.get(i)][Augpath.get(i+1)] < criticalWeight) {
					criticalWeight = residualFlow[Augpath.get(i)][Augpath.get(i+1)];
				}
			}
			/////Adjust edge weights of Augmenting path/////////////////////////////
			for(int i=0; i<Augpath.size()-1; i++) {
				residualFlow[Augpath.get(i)][Augpath.get(i+1)] = residualFlow[Augpath.get(i)][Augpath.get(i+1)] - criticalWeight;
				residualFlow[Augpath.get(i+1)][Augpath.get(i)] = residualFlow[Augpath.get(i+1)][Augpath.get(i)] + criticalWeight;
			}
		}
	}
	
	/////Print output/////////////////////////////////////////////////////////
	public static void printOutput() {
		int flow = 0;
		for(int i=0; i<noOfVertex; i++) {
			if(residualFlow[1][i] != -1)
				flow = flow + residualFlow[1][i];
		}
		System.out.println(flow);
		for(Integer[] i : edges) {
			for(int j=0; j<2; j++) {
				System.out.print(i[j]+" ");
			}
			System.out.print(residualFlow[i[1]][i[0]]);
			System.out.println();
		}
	}
}
