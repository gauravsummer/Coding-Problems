package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class SearchAlgo {
	static HashMap<String, cityDetails> cityList = new HashMap<String, cityDetails>();
	
	/* To store details of nodes*/
	class cityDetails {
		String cityName;
		double latitude;
		double longitude;
		cityDetails currentParent;
		TreeMap<String, Integer> neighbourList;
		public cityDetails(String city) {
			this.cityName = city;
			neighbourList = new TreeMap<String, Integer>();
		}
	}
	
	/* To read the input file*/
	 public void readFile() {
		 Scanner scan = null;
			try {
				scan = new Scanner(new File("C:/Users/Lavi/Desktop/ncsu/AI/Assignments/1/roads.txt"));
				while(scan.hasNextLine()) {
					String mapData = scan.nextLine();
					int i=0;
					int e = mapData.indexOf(")");
					if(mapData.substring(0,4).equals("road")){
						String [] coords = mapData.substring(5, e).split(" ");
						String cityName = coords[0];
						String neighborCity = coords[1];
						int dist = Integer.parseInt(coords[2]);
						if(cityList.get(cityName) == null) {
							cityList.put(cityName, new cityDetails(cityName));
						}
						if(cityList.get(neighborCity)==null) {
							cityList.put(neighborCity, new cityDetails(neighborCity));
						}
						cityList.get(cityName).neighbourList.put(neighborCity, dist);
						cityList.get(neighborCity).neighbourList.put(cityName, dist);
					}
					if(mapData.substring(0,4).equals("city")){
						String [] coords = mapData.substring(5, e).split(" ");
						String cityName = coords[0];
						double lat = Double.parseDouble(coords[1]);
						double lng = Double.parseDouble(coords[2]);
						cityList.get(cityName).latitude = lat;
						cityList.get(cityName).longitude = lng;
					}
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				scan.close();
			}
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchAlgo algo = new SearchAlgo();
		algo.readFile();
		/* For answer of question 3(a) */
		List<ArrayList<String>> result;
		System.out.println("Ques 3(a): Path from Urziceni to Mehadia \n\n*****DFS: *****");
		result = algo.DFS("urziceni", "mehadia");
		algo.print(result);
		System.out.println("*****BFS: *****");
		result = algo.BFS("urziceni", "mehadia");
		algo.print(result);
		result = algo.aStar("urziceni", "mehadia");
		System.out.println("*****ASTAR: *****");
		algo.print(result);
		/* For answer of question 3(b) */
		System.out.println("***********************************\nQues 3(b): BFS outperforms DFS for path between Urziceni and Fagaras\n");
		System.out.println("*****DFS: *****");
		result = algo.DFS("urziceni", "fagaras");
		algo.print(result);
		System.out.println("*****BFS: *****");
		result = algo.BFS("urziceni", "fagaras");
		algo.print(result);
		/* For answer of question 3(c) */
		System.out.println("***********************************\nQues 3(C): DFS outperforms ASTAR for path between Rimnicu vilcea and Lugoj\n");
		System.out.println("*****DFS: *****");
		result = algo.DFS("rimnicu_vilcea", "lugoj");
		algo.print(result);
		result = algo.aStar("rimnicu_vilcea", "lugoj");
		System.out.println("*****ASTAR: *****");
		algo.print(result);
	}
	
	/* To print the expanded nodes and path returned */
	public void print(List<ArrayList<String>> result) {
		ArrayList<String> path = result.get(0);
		ArrayList<String> exploredCities = result.get(1);
		System.out.println("Number of nodes expanded : "+exploredCities.size());
		System.out.print("Expanded nodes:- ");
		for(String str: exploredCities)
			System.out.print(str+" ");
		System.out.println();
		System.out.println("Path length: "+path.size());
		System.out.print("Path: ");
		for(String str: path)
			System.out.print("-> "+str);
		System.out.println("\n");
	}
	
	/* BFS implementation */
	public List<ArrayList<String>> BFS(String start, String end) {
		HashSet<String> explored = new HashSet<String>();
		Queue<cityDetails> frontier = new LinkedList<cityDetails>();
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> citiesExplored = new ArrayList<String>();
		frontier.add(cityList.get(start));
		cityList.get(start).currentParent = null;
		while(!frontier.isEmpty()) {
			cityDetails curnode = frontier.poll();
			citiesExplored.add(curnode.cityName);
			/* If the destination city is found */
			if(curnode.cityName.equals(end)) {
				/* Backtracking the path */
				while(curnode != null) {
					path.add(curnode.cityName);
					curnode = curnode.currentParent;
				}	
				Collections.reverse(path);
				List<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
				output.add(path);
				output.add(citiesExplored);
				return output;
			}
			else {
				for(String neighbour : curnode.neighbourList.keySet()) {
					cityDetails neighbourCity = cityList.get(neighbour);
					if(! frontier.contains(neighbourCity) && !explored.contains(neighbour)) {
						frontier.add(neighbourCity);
						neighbourCity.currentParent = curnode;
					}
					explored.add(curnode.cityName);
				}
			}
		}
		System.out.println("No path found...");
		return null;
	}
	
	/* DFS implementation */
	public List<ArrayList<String>> DFS(String start, String end) {
		HashSet<String> explored = new HashSet<String>();
		Stack<cityDetails> frontier = new Stack<cityDetails>();
		ArrayList<String> citiesExplored = new ArrayList<String>();
		ArrayList<String> path = new ArrayList<String>();
		frontier.add(cityList.get(start));
		cityList.get(start).currentParent = null;
		while(!frontier.isEmpty()) {
			cityDetails curnode = frontier.pop();
			citiesExplored.add(curnode.cityName);
			/* If the destination city is found */
			if(curnode.cityName.equals(end)) {
				/* Backtracking the path */
				while(curnode != null) {
					path.add(curnode.cityName);
					curnode = curnode.currentParent;
				}	
				Collections.reverse(path);
				List<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
				output.add(path);
				output.add(citiesExplored);
				return output;
			}
			else {
				for(String neighbour : curnode.neighbourList.keySet()) {
					cityDetails neighbourCity = cityList.get(neighbour);
					if(!explored.contains(neighbour)) {
						if(frontier.contains(neighbourCity))
							frontier.remove(neighbourCity);
						frontier.add(neighbourCity);
						neighbourCity.currentParent = curnode;
					}
					explored.add(curnode.cityName);
				}
			}
		}
		System.out.println("No path found...");
		return null;
	}
	
	/* Heuristic function returning straight line distance between two cities */
	public double heuristic(cityDetails city1, cityDetails city2)
	{
		return 100 * Math.sqrt(
				Math.pow(((city1.latitude - city2.latitude)), 2) + 
				Math.pow(((city1.longitude - city2.longitude)), 2));
	}
	
	/* ASTAR implementation */
	public List<ArrayList<String>> aStar(String start, String end) {
		HashSet<cityDetails> explored = new HashSet<cityDetails>();
		/* Maps to store updated distances and total distance(distance till the node + heuristic to the destination) */
		final HashMap<cityDetails, Double> distFromSrc = new HashMap<cityDetails, Double>();
		final HashMap<cityDetails, Double> finalScore = new HashMap<cityDetails, Double>();
		final cityDetails snode = cityList.get(start), enode = cityList.get(end);
		distFromSrc.put(cityList.get(start), 0.0);
		finalScore.put(cityList.get(start), heuristic(snode, enode));
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> citiesExplored = new ArrayList<String>();
		/* Frontier: a priority queue to get nodes having least total cost(distance till that node + heuristic) */
		PriorityQueue<cityDetails> frontier = new PriorityQueue<cityDetails>(cityList.size(), new Comparator<cityDetails>(){
			public int compare(cityDetails city1, cityDetails city2){
				double c1 = finalScore.get(city1);
				double c2 = finalScore.get(city2);
				if(c1 <= c2)
					return -1;
				else
					return 1;
				}
		});
		frontier.add(cityList.get(start));
		snode.currentParent = null;
		while(!frontier.isEmpty()) {
			cityDetails currNode = frontier.poll();
			citiesExplored.add(currNode.cityName);
			/* If the destination city is found */
			if(currNode.cityName.equals(end)) {
				/* Backtracking the path */
				while(currNode != null) {
					path.add(currNode.cityName);
					currNode = currNode.currentParent;
				}
				Collections.reverse(path);
				List<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
				output.add(path);
				output.add(citiesExplored);
				return output;
			}
			explored.add(currNode);
			for(String neighbour : currNode.neighbourList.keySet()) {
				cityDetails neighNode = cityList.get(neighbour);
				double tempScore = distFromSrc.get(currNode) + currNode.neighbourList.get(neighbour);
				/* Don't have to update the dist for a node if the updated dist is higher than previous dist */
				if(explored.contains(neighNode) && tempScore >= distFromSrc.get( neighNode)){
					continue;
				}				
				neighNode.currentParent = currNode;
				double previousScore;
				/* Setting default value */
				if(distFromSrc.get(neighNode) == null)
					previousScore = 300000.0;
				else
					previousScore = distFromSrc.get(neighNode);
				/* If smaller path from source to this node is found, update the distance from source */
				if(previousScore > tempScore)
					distFromSrc.put(neighNode, tempScore);
				finalScore.put(neighNode, distFromSrc.get(neighNode) + heuristic(neighNode, enode));
				if(!frontier.contains(neighNode)) {
					frontier.add(neighNode);
				}
				else if(tempScore >= distFromSrc.get(neighNode)) {
					continue;
				}
			}
		}
		System.out.println("No path found...");
		return null;
	}		
}
