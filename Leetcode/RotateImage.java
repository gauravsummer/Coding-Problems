package common;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[5][5];
		matrix[0][0] = 0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i==0 && j==0)
					matrix[i][j] = 0;
				else
					matrix[i][j] = 1;
			}
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
					System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

		boolean[] row = new boolean[5];
		boolean[] column = new boolean[5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
					System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
