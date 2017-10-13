package common;

import java.util.ArrayList;
import java.util.Scanner;

public class mult {
public static int noOfMatrix = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		noOfMatrix = scan.nextInt();
/////////////TO STORE ATTRIBUTES OF MATRICES//////////////////////////////////////////		
		int[] matrixAttribute = new int[noOfMatrix+1];
		for(int i=0; i<matrixAttribute.length; i++){
			matrixAttribute[i] = scan.nextInt();
		}

/////////////TABLE TO STORE SUBPROBLEM RESULTS///////////////////////////////////////		
		int[][] matrix = new int[noOfMatrix][noOfMatrix];		
		matrix = matrixChainOrder(matrixAttribute);
		
////////////CALL FUNCTION TO PRINT OPTIMAL PARANTHESIS////////////////////////////		
		printParenthesis(matrix,1,noOfMatrix);
	}
	
///////////////////////////FOR GETTING OPTIMAL MATRIX MULTIPLICATION ORDER/////////// 	
	public static int[][] matrixChainOrder(int[] matrixAttributes){
		int n = matrixAttributes.length-1;
//////////////////TO STORE VALUES FOR OPTIMAL SOLUTION TO SUBPROBLEMS////////////////		
		int[][] matrix = new int[n][n];
//////////////////TO RETRIEVE OPTIMAL PARENTHESIS////////////////////////////////////		
		int[][] paren = new int[n+1][n+1];
		
		for(int i=0; i<n; i++)
			matrix[i][i] = 0;
		
//////////////////TO CALCULATE AND STORE OPTIMAL SOLUTION///////////////////////////
		for(int l=1; l<n; l++){
			for(int i=0; i<(n-l); i++){
				int j = i+l;
				matrix[i][j] = Integer.MAX_VALUE;
				for(int k =i; k<(j); k++){
					int q = matrix[i][k] + matrix[k + 1][j] + matrixAttributes[i]*matrixAttributes[k + 1]*matrixAttributes[j + 1];
					if(q < matrix[i][j]){
					matrix[i][j] = q;
					paren[i+1][j+1] = k + 1;
					}
				}
			}
		}
		return paren;
	}
	
///////////////////FOR PRINTING OPTIMAL PARENTHESIS//////////////////////////////////	
	public static void printParenthesis(int[][] paren, int i, int j){
		if (i == j )
				System.out.print("M"+i);
		else {
			if(!(i == 1 && j == noOfMatrix))
				System.out.print("( ");
			printParenthesis(paren,i,paren[i][j]);
			System.out.print(" * ");
			printParenthesis(paren, paren[i][j]+1, j);
			if(!(i == 1 && j == noOfMatrix))
				System.out.print(" )");
			else
				System.out.println();
		}
	}

}
