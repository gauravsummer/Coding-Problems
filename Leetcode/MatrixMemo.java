package common;

import java.util.Scanner;

public class MatrixMemo {

	static int s[][];
	static int noOfCalls=0;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the number of matrix dimensions");
		int noOfDim = scan.nextInt();
		System.out.println("Enter the matrix dimensions");
		int p[] = new int[noOfDim];
		for(int i=0; i<noOfDim; i++)
			p[i] = scan.nextInt();
		s = new int[noOfDim][noOfDim];
		scan.close();
		
		final long startTime = System.nanoTime();
		System.out.println("Number of scalar multiplications: "+memoized(p, noOfDim));
		System.out.print("Optimal Parenthesization: ");
		optimalParens(s,p, 1, noOfDim-1);
		System.out.println();
		System.out.println("No of Recursive Calls: " +noOfCalls);
		System.out.print("Run Time: ");
		System.out.println((System.nanoTime() - startTime) + " ns");
	}
	
	public static int memoized(int p[], int n){
		int m[][] = new int[n][n];
		for(int i=1; i<n; i++)
			for(int j=i; j<n; j++)
				m[i][j] = Integer.MAX_VALUE;	
		return memoized(m, p, 1, n-1);
	}
	
	public static int memoized(int m[][], int p[], int i, int j){
		noOfCalls++;
		if(m[i][j]<Integer.MAX_VALUE)
			return m[i][j];
		if(i == j)
			m[i][j] = 0;
		else{
			for(int k=i; k<j; k++){
				int q = memoized(m, p, i, k) + memoized(m, p, k+1, j) + p[i-1]*p[k]*p[j];
				if(q < m[i][j]){
					m[i][j] = q;
					s[i][j] = k;
				}
			}
		}
		return m[i][j];	
	}

	public static void optimalParens(int s[][],int p[],int i,int j){
	if(i == j)
		System.out.print("M"+i);
	else{
		System.out.print("(");
		optimalParens(s, p, i, s[i][j]);
		optimalParens(s, p, s[i][j]+1, j);
		System.out.print(")");
		}
	}
}
