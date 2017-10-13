package common;

import java.util.Scanner;

public class MatrixDP {
	static int noOfCalls=0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of matrix dimensions");
		int noOfDim = scan.nextInt();
		System.out.println("Enter the matrix dimensions");
		int p[] = new int[noOfDim];
		for(int i=0; i<noOfDim; i++)
			p[i]=scan.nextInt();
		scan.close();
		
		final long startTime = System.nanoTime();
		System.out.println("Number of scalar multiplications: "+ matrixChainOrder(p, noOfDim));
		System.out.println("No of Recursive Calls: " + noOfCalls);
		System.out.print("Run Time: ");
		System.out.println((System.nanoTime() - startTime) + " ns");
	}
	
	public static int matrixChainOrder(int p[],int n){
		noOfCalls++;
		int m[][] = new int[n][n];
		int s[][] = new int[n][n];
		for(int i=0; i<n; i++)
			m[i][i] = 0;
		for(int l=2; l<n; l++){
			for(int i=1; i<n-l+1; i++){
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++){
					int q= m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(q < m[i][j]){
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		System.out.print("Optimal Parenthesization: ");
		optimalParens(s,p, 1, n-1);
		System.out.println();
		return m[1][n-1];	
	}

	public static void optimalParens(int s[][],int p[],int i,int j){
	if(i==j)
		System.out.print("M"+i);
	else{
		System.out.print("(");
		optimalParens(s, p, i, s[i][j]);
		optimalParens(s, p, s[i][j]+1, j);
		System.out.print(")");
		}
	}
}
