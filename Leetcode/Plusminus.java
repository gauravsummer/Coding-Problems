package common;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Plusminus {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i<n;  i++){
			arr[i] = in.nextInt();
		}
		double positive =0;
		double negative =0;
		double zero =0;
		for(int i = 0; i<arr.length; i++){
			if(arr[i] == 0)
				zero++;
			else if(arr[i] > 0)
				positive++;
			else
				negative++;
		}
		System.out.printf("%.6f\n%.6f\n%.6f", positive/n, negative/n, zero/n);
	}
}
