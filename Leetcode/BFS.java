package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS {
private static int[] pred;
private static Queue<Integer> queue = new LinkedList<Integer>();
private static String[] color;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int noOfVertex = scan.nextInt();
		int noOfEdges = scan.nextInt();
		
		pred = new int[noOfEdges];
		color = new String[noOfEdges];
		//System.out.println("edges and vertex : "+noOfEdges +" "+noOfVertex);
		int[][] initialMatrix = new int[noOfVertex][noOfVertex];
		int[][] residual = new int[noOfVertex][noOfVertex];
		for(int i=0; i<noOfVertex; i++) {
			for(int j=0; j<noOfVertex; j++) {
				initialMatrix[i][j] = -1;
				residual[i][j] = -1;
			}
		}
		ArrayList<Integer[]> edges = new ArrayList<Integer[]>(); 
		for(int i=0; i<noOfEdges; i++) {
				int src = scan.nextInt();
				int dest = scan.nextInt();
				Integer[] edge = {src,dest};
				edges.add(edge);
				//System.out.println(src + " "+dest);
				int weight = scan.nextInt();
				initialMatrix[src][dest] = weight;
				initialMatrix[dest][src] = 0;
				residual[src][dest] = weight;
				residual[dest][src] = 0;
		}
		boolean pathFound = true;
		while(pathFound) {
			pathFound = false;
			for(int i=0; i<noOfVertex; i++) {
				pred[i] = -1;
				color[i] = "WHITE";
			}
			color[0] = "GREY";
			queue.clear();
			queue.add(0);
			Stack<Integer> stack = new Stack<Integer>();
			ArrayList<Integer> path = new ArrayList<Integer>();
			while(queue.size() != 0) {
				int u = queue.remove();
				if(u == 1)
					pathFound = true;
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
			if(pathFound) {
				stack.add(1);
				for(int i = 1; i != 0;) {
					stack.add(pred[i]);
					i = pred[i];
				}
			}
			
			int k = stack.size();
			for(int j=0; j<k; j++) {
				path.add(stack.pop());
			}
			int critical = 100000;
			for(int i=0; i<path.size()-1; i++) {
				if(residual[path.get(i)][path.get(i+1)] < critical) {
					critical = residual[path.get(i)][path.get(i+1)];
				}
			}
			for(int i=0; i<path.size()-1; i++) {
				residual[path.get(i)][path.get(i+1)] = residual[path.get(i)][path.get(i+1)] - critical;
				residual[path.get(i+1)][path.get(i)] = residual[path.get(i+1)][path.get(i)] + critical;
			}
		}
		int flow = 0;
		for(int i=0; i<noOfVertex; i++) {
			if(residual[1][i] != -1)
				flow = flow + residual[1][i];
		}
		System.out.println(flow);
		for(Integer[] i : edges) {
			for(int j=0; j<2; j++) {
				System.out.print(i[j]+" ");
			}
			System.out.print(residual[i[1]][i[0]]);
			System.out.println();
		}
	}
}
