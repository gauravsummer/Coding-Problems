package common;
import java.util.ArrayList;
import java.util.Scanner;

public class Heap3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;
///////////Arraylist to hold the heap///////////////////////////////////////////////////////		
		ArrayList<Integer> integer = new ArrayList<Integer>();
///////////Reading the input///////////////////////////////////////////////////////////////		
		while(scan.hasNext()){
			input=scan.nextLine();
///////////calling Insert function whenever the input has "add"/////////////////////////////			
			if(input.contains("add")){
				int number = Integer.parseInt(input.substring(4, (input.length())));
				Insert(integer,number);	
			}
///////////calling Remove function whenever input has remove////////////////////////////////			
			if(input.contains("remove")){
				System.out.println(RemoveMin(integer));
			}
		}
		scan.close();
	}
///////////Function to maintain Min heap property///////////////////////////////////////////	
	public static void MinHeapify(ArrayList<Integer> array, int index){
		if(array.size()<=1)
			return;
		double size = array.size();
///////////To use ceiling value to get address for node till which there are children///////
		double ceils = Math.ceil((size-1)/3)-1;
		int ceil=(int)ceils;
		if(index <= ceil)
		{
			int smallest = index;
///////////Assigning address of children of a node//////////////////////////////////////////
			int left = Left(index);
			int right = Right(index);
			int center = Center(index);
//////////comparing parent with left child to get smaller///////////////////////////////////		
			if(left <= array.size()-1 && array.get(index) > array.get(left)){
				smallest = left;
			}
//////////comparing smaller with center child//////////////////////////////////////////////			
			if(center <= array.size()-1 && array.get(smallest) > array.get(center)){
				smallest = center;
			}
//////////comparing smaller with right child///////////////////////////////////////////////			
			if(right <= array.size()-1 && array.get(smallest) > array.get(right)){
				smallest = right;
			}
//////////if any child is smaller than parent node, swap parent and smallest child/////////			
			if(smallest != index){
				int temp=array.get(index);
				array.set(index, array.get(smallest));
				array.set(smallest, temp);
//////////recursive call to MinHeapify wwith new location of parent node//////////////////				
				MinHeapify(array,smallest);
			}
		}
	}
//////////function to get index of Left child of a node/////////////////////////////////////	
	public static int Left(int index){
		return((index+1)*3-2);
	}
//////////function to get index of Right child of a node/////////////////////////////////////
	public static int Right(int index){
		return((index+1)*3);
	}
//////////function to get index of Center child of a node/////////////////////////////////////	
	public static int Center(int index){
		return((index+1)*3-1);
	}
//////////function to get index of Parent of a node///////////////////////////////////////////	
	public static int Parent(int index){
		double ind=index;			
		double ceils=Math.ceil(ind/3)-1;
		return (int)ceils;
	}
//////////Insert function to add new values to the heap////////////////////////////////////////	
	public static void Insert(ArrayList<Integer> array,int element){
		array.add(element);
		PercolateUp(array,array.size()-1);
	}
//////////Function to set the newly added element to its correct position//////////////////////	
	public static void PercolateUp(ArrayList<Integer> array,int index){
		int parent = Parent(index);
		if(parent<0){
			return;	
		}
//////////Swap element if it is smaller than its parent till it reaches correct position///////		
		if(array.get(index) < array.get(parent))
		{
			int temp=array.get(index);
			array.set(index, array.get(parent));
			array.set(parent, temp);
			PercolateUp(array,parent);
		}
	}
///////////Function to remove and extract the smallest element of the heap////////////////////	
	public static int RemoveMin(ArrayList<Integer> array){
		if(array.size()<1)
			System.out.println("error : underflow");
		int min = array.get(0);
///////////Copy last element to the root of the heap//////////////////////////////////////////		
		array.set(0, array.get(array.size()-1));
///////////Reducing the size of the heap//////////////////////////////////////////////////////		
		array.remove(array.size()-1);
//////////Call to MinHeapify for maintaining the min heap property///////////////////////////		
		MinHeapify(array,0);
//////////Return the minimum element(root node)///////////////////////////////////////////////		
		return min;
	}
}
