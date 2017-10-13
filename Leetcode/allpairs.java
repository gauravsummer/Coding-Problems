package common;

import java.util.ArrayList;
import java.util.Scanner;

public class allpairs {
private static int[][] path;
private static int destination = 0;
private static int[][] shrotestPathLength;
private static ArrayList<String> words;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		words = new ArrayList<String>();
		ArrayList<String[]> queries = new ArrayList<String[]>();
		int noOfWords = scan.nextInt();
		for(int i=0; i<noOfWords; i++){
			words.add(scan.next());
		}
		int noOfQueries = scan.nextInt();
		for(int i=0; i<noOfQueries; i++){
			String[] query = new String[2];
			for(int j=0; j<2; j++)
			{
				query[j] = scan.next();
			}
			queries.add(query);	
		}
		scan.close();
		/////Initialization/////////////////////////////////////////////////////////
		shrotestPathLength = new int[noOfWords][noOfWords];
		path = new int[noOfWords][noOfWords];
		for(int i=0; i<noOfWords; i++){
			for(int j=0; j<noOfWords; j++){
				if(i==j){
					shrotestPathLength[i][j] = 0;
					path[i][j] = -1;
				}
				else{
					shrotestPathLength[i][j] = 1111111;
					path[i][j] = -1;
				}
			}
		}
		/////find edges and assign edge weights///////////////////////////////
		for(int s=0; s<words.size(); s++){
			for(int d=s+1; d<words.size(); d++){
				if(words.get(s).length() == words.get(d).length()){
					int counter = 0;
					int index = 0;
					for(int i=0; i<words.get(s).length(); i++){
						if(words.get(s).charAt(i) != words.get(d).charAt(i)){
							counter++;
							index = i;
						}
					}
					if(counter == 1){
						shrotestPathLength[s][d] = Math.abs(words.get(s).charAt(index) - words.get(d).charAt(index));
						shrotestPathLength[d][s] = shrotestPathLength[s][d];
						path[s][d] = s;
						path[d][s] = d;
					}
				}
			}
		}
		/////updating path weight and vertex used for shortest path/////////////////
		for(int k=0; k<noOfWords; k++){
			for(int i=0; i<noOfWords; i++){
				for(int j=0; j<noOfWords; j++){
					if(shrotestPathLength[i][j] > shrotestPathLength[i][k] + shrotestPathLength[k][j]){
						shrotestPathLength[i][j] = shrotestPathLength[i][k] + shrotestPathLength[k][j];
						path[i][j] = k;
					}
				}
			}
		}	
		
		print(queries, noOfWords);
	}
	
	/////Print expected output/////////////////////////////////////////////
	public static void print(ArrayList<String[]> queries, int noOfWords) {
		float totalReachable = 0;
		for(int i=0; i<noOfWords; i++){
			
			for(int j=0; j<noOfWords; j++){
				if(shrotestPathLength[i][j] != 1111111){
					totalReachable++;
				}
			}
		}
		float avg = totalReachable / noOfWords;
		System.out.printf("%.2f", avg);	
		System.out.println();
		for(String[] query: queries){
			int src = words.indexOf(query[0]);
			int dest = words.indexOf(query[1]);
			if(shrotestPathLength[src][dest] != 1111111){
				System.out.print(shrotestPathLength[src][dest]+" ");
				System.out.print(words.get(src)+" ");
				destination = dest;
				pathRecursive(src, dest);
				System.out.println();
			}
			else if(shrotestPathLength[src][dest] == 1111111){
				System.out.println(query[0]+" "+query[1]+" not reachable");
			}
		}
	}
	
	////Print the path recursively/////////////////////////////////////
	public static void pathRecursive(int i, int j) {
		if(path[i][j] != i) {
			pathRecursive(i, path[i][j]);
		}
		else {
			if(j == destination) {
				System.out.print(words.get(j));
				return;
			}
			else {
				System.out.print(words.get(j)+" ");
				return;
			}
		}
		pathRecursive(path[i][j],j);
	}
}
