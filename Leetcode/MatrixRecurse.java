package common;

import java.util.Scanner;

public class MatrixRecurse {

	static int s[][];
	static int noOfCalls = 0;
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of matrix dimensions");
		int noOfDim = scan.nextInt();
		System.out.println("Enter the matrix dimensions");
		int p[] = new int[noOfDim];
		for(int i=0;i<noOfDim;i++)
			p[i]=scan.nextInt();
		scan.close();
		
		s = new int[noOfDim][noOfDim];
		final long startTime = System.nanoTime();
		System.out.println("Number of scalar multiplications: "+matrixChainOrder(p,1,noOfDim-1));
		System.out.print("Optimal Parenthesization: ");
		optimalParens(s, p, 1, noOfDim-1);
		System.out.println();
		System.out.println("No of Recursive Calls: " +noOfCalls);
		System.out.print("Run Time: ");
		System.out.println((System.nanoTime() - startTime) + " ns");
	}

	public static int matrixChainOrder(int p[], int i, int j){
		noOfCalls++;
		if(i == j)
			return 0;
		int scalarMult = Integer.MAX_VALUE;
		for(int k=i; k<j; k++){
			int q = matrixChainOrder(p, i, k) + matrixChainOrder(p, k+1, j) + p[i-1]*p[k]*p[j];
			if(q < scalarMult){
				scalarMult = q;
				s[i][j] = k;
			}
		}
		return scalarMult;
	}
	
	public static void optimalParens(int s[][], int p[], int i, int j){
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

