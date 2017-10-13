package common;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class qsort {
	public static int k=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
////////////////////Set k to hold argument passed during run of program///////////////////////////		
		k=Integer.parseInt(args[0]);
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
////////////////////ArrayList to hold and add input integers//////////////////////////////////////  		
		ArrayList<Integer> integer = new ArrayList<Integer>();
		String str=null;
		while((str=input.readLine())!=null && str.length()!=0 ){
			int number = Integer.parseInt(str);
			integer.add(number);
		}
		input.close();
////////////////////Converting ArrayList to Array for faster processing////////////////////////////		
		int s = integer.size();
		int[] intArray = new int[s];
		for(int i = 0; i<s; i++)
			intArray[i] = integer.get(i).intValue();
////////////////////calling quick sort(array, start index, end index) and calculating the time taken for quick sort/////////////////		
		long t0 = getMilliseconds();
		QuickSort(intArray, 0, intArray.length-1);
		long t1 = getMilliseconds();
///////////////////Printing the time taken by quick sort////////////////////////////////////////////		
		System.err.println( t1 - t0 );
////////////////////Printing the sorted array///////////////////////////////////////////////////////		
		for(int i = 0; i<s; i++)
			System.out.println(intArray[i]);
	}
	
//////Quicksort function which calls to Insertion sort when input array has less than or equal to k elements///////	
	public static void QuickSort(int[] input, int start, int end){
///////////If size of input is more than k then using quicksort//////////////////////////////////////////////
		if(start+k < end)
		{
			int q = Partition(input, start, end);
				QuickSort(input, start, q-1);
				QuickSort(input, q+1, end);
			}
///////////If size of input is less than k, using Insertion sort/////////////////////////////////////////////		
		else 
			if(start < end)
			InsertionSort(input,start,end);		
	}

////////////Partition logic for quicksort//////////////////////////////////////////////////////////////////////	
	public static int Partition(int[] input, int start, int end){
		int x = input[end];
		int i = start-1;
		for(int j=start; j<end; j++){
			if(input[j] <= x){
				i = i+1;
				int temp = input[i];
				input[i] = input[j];
				input[j]= temp;
				}
			}
		int temp = input[end];
		input[end]= input[i+1];
		input[i+1]= temp;
		return i+1;
	}
	
//////////////////Insertion sort/////////////////////////////////////////////////////////////////////	
	public static void InsertionSort(int[] A, int start, int end){
		for(int i=start+1; i <= end; i++)
		{
			int x = A[i];
			int j = i-1;
			while(j >= start && A[j] > x){
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = x;	
		}
	}
	
/////////////////To get current time////////////////////////////////////////////////////////////////////////	
	public static long getMilliseconds() {
		return System.currentTimeMillis();
		}

}
