package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class dependency {

//////////////ADJACENCY LIST///////////////////////////////////////////////	
private static LinkedList <Integer> adj[];
//////////////ADJACENCY LIST FOR REVERSE EDGES//////////////////////////////////////
private static LinkedList <Integer> adjReverse[];
//////////////STACK TO STORE EDGES IN REVERSE FINISHING ORDER///////////////////////
public static Stack<Integer> stack = new Stack<Integer>();
//////////////STORE COLOR OF THE VERTEX/////////////////////////////////////////////
public static String[] color;
//////////////STORE FINISH TIME FOR A VERTEX////////////////////////////////////////
public static int[] finish;
//////////////ARRAYLIST TO STORE THE VERTICES///////////////////////////////////////
private static ArrayList<String> vertices = new ArrayList<String>();
private static int noOfVertices;
private static int noOfEdges;
private static int time;
/////////////FLAG TO CHECK FOR |SCC| > 1////////////////////////////////////////////
private static boolean found = false; 
public static int counter = 0;
/////////////ARRAYLIST TO STORE EDGES OF A SCC//////////////////////////////////////
private static ArrayList<Integer> singleSCC = null;
/////////////ARRAYLIST FOR ALL SCC//////////////////////////////////////////////////
private static  ArrayList<ArrayList<Integer>> allSCC = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
////////////////INITIALIZING ADJACENCY LISTS, EDGEE.COLOR AND EDGE.FINISH TIME//////		
		noOfVertices = scan.nextInt();
		adjReverse = new LinkedList[noOfVertices];
		adj = new LinkedList[noOfVertices];
		color = new String[noOfVertices];
		finish = new int[noOfVertices];
		for(int i=0; i<noOfVertices; i++){
			String vertex = scan.next();
			vertices.add(vertex);
			adj[i] = new LinkedList();
			adjReverse[i] = new LinkedList();
		}
		
//////////GETTING EDGES AS INPUT AND ADDING TO ADJACENCY LIST/////////////////////// 		
		noOfEdges = scan.nextInt();
		for(int i=0; i<noOfEdges; i++){
			String from = scan.next();
			String to = scan.next();	
			int edgeFrom = vertices.indexOf(from);
			int edgeTo = vertices.indexOf(to);
			addEdge(edgeFrom, edgeTo);
		}
		
		DFS(adj);
		reverseEdges();
		DFS(adjReverse);
		for(int i=0; i<noOfVertices; i++){
			color[i] = "WHITE";
		}
		while(!stack.empty()){
			found = false;
			singleSCC = new ArrayList<Integer>();
			int vertexSSC = (int) stack.pop();
			if(color[vertexSSC].equals("WHITE")){
				counter=0;
				findSCC(vertexSSC, adjReverse);
/////////////////SORT SCC AS PER THE OCCURANCE OF THE EDGES/////////////////////////				
				if(found){					
					Collections.sort(singleSCC);
					allSCC.add(singleSCC);
				}
			}
		}
		
/////////////////SORT ALL COMPONENTS////////////////////////////////////////////////		
		Collections.sort(allSCC, new ColumnComparator());
		
//////////////////PRINT STRONGLY CONNECTED COMPONENTS///////////////////////////////		
		for(ArrayList<Integer> scc:allSCC){
			for(int i:scc){
				if(scc.indexOf(i) != (scc.size()-1))
					System.out.print(vertices.get(i)+" ");
				else
					System.out.print(vertices.get(i));
			}
			System.out.println();
		}
	}

//////////////////ADDING EDGES TO ADJACENCY LIST////////////////////////////////////	
	static void addEdge(int vertexFrom, int vertexTo){
		adj[vertexFrom].add(vertexTo);
	}
	
//////////////////DFS///////////////////////////////////////////////////////////////	
	public static void DFS(LinkedList <Integer>[] adjList){
		for(int i=0; i<noOfVertices; i++){
			color[i] = "WHITE";
			time = 0;
			finish[i] = -1;
		}
		for(int i=0; i<noOfVertices; i++){
			if(color[i].equals("WHITE")){
				recursiveDFS(i, adj);
			}
		}
	}	
	
//////////////RECURSIVE DFS/////////////////////////////////////////////////////////	
	public static void recursiveDFS(int vertex, LinkedList <Integer>[] adjList){
		color[vertex] = "GREY";
		for(int i=0; i<adj[vertex].size(); i++){
			if(color[adj[vertex].get(i)].equals("WHITE")){
					recursiveDFS(adj[vertex].get(i), adjList);	
			}
		}
		color[vertex] = "BLACK";
		finish[vertex] = time + 1;
		stack.push(vertex);
	}

///////////////FINDING SCC//////////////////////////////////////////////////////////	
	public static void findSCC(int vertex, LinkedList <Integer>[] adjList){
		color[vertex] = "GREY";
		for(int i=0; i<adjList[vertex].size(); i++){
			if(color[adjList[vertex].get(i)].equals("WHITE")){
					counter++;
					findSCC(adjList[vertex].get(i), adjList);	
			}
		}
		color[vertex] = "BLACK";
//////////////ADD SCC OF SIZE > 1 T0 ARRAYLIST singleSCC////////////////////////////		
		if(counter>0){
			singleSCC.add(vertex);
			found = true;
		}
	}
	
///////////////REVERSE THE EDGES AND STORE IN NEW ADJACENCY LIST////////////////////	
	public static void reverseEdges(){
		for(int i=0; i<noOfVertices; i++){
			for(int j=0; j<adj[i].size(); j++){
				adjReverse[adj[i].get(j)].add(i);
			}
		}
	}
}

/////////////OVERRIDE COMPARATOR TO COMPARE AND SORT ARRAYLIST//////////////////////
class ColumnComparator implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> ar1, ArrayList<Integer> ar2){
        return ar1.get(0).compareTo(ar2.get(0));
    }
}
