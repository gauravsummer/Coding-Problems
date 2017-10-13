package common;

import java.util.HashSet;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int[][] mat = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("After the function:");
		rotateMat(mat);
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void rotateMat(int[][] mat) {
		for(int i=0; i<mat.length/2; i++) {
			int start = i;
			int end = mat.length - i - 1;
			for(int j = start; j<end; j++) {
				int offset = j-start;
				int temp = mat[start][j];
				mat[start][j] = mat[end - offset][start];
				mat[end - offset][start] = mat[end][mat.length-1-j];
				mat[end][end - offset] = mat[j][end];
				mat[j][end] = temp;
			}
		}
	}

}
