package common;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        //int i = 0;
        
        int flag = 1;
        
           // System.out.println(smallest);
        
        while(flag != 0){
        	flag=0;
            int counter = 0;
            int smallest = 10000;
            for(int j=0; j<n; j++){
                if(arr[j] < smallest && arr[j] > 0)
                	smallest = arr[j];
            }
            for(int j=0; j<n; j++){
            	if(arr[j] > 0){
            		arr[j] = arr[j] - smallest;
            		counter++;
            		flag++;
            	}
            }
            if(counter>0)
            System.out.println(counter);
        }
        //for(int i=0; i<n; i++)
        	//System.out.println(arr[i]);
    }
}
