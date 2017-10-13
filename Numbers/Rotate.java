package numbers;

public class Rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
		System.out.println("marix initial: ");
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		Rotate r = new Rotate();
		r.rotate(matrix);
		System.out.println("marix after: ");
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i<n/2; i++) {
			int first = i;
			int last = n - 1 - i;
			for(int j=first; j<last; j++) {
				int offset = j-first;
				System.out.println("off "+offset);
				int top = matrix[first][j];
				matrix[first][j] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[j][last];
				matrix[j][last] = top;
			}
		}
	}
	
	public static void rotateLeft(int[][] mat) {
		int n = mat.length;
		for(int i=0; i<n/2; i++) {
			int first = i, last = n-1-i;
			for(int j=first; j<last; j++) {
				int offset = j-first;
				int top = mat[i][last-offset];
				mat[i][last-offset] = mat[last - offset][last];
				mat[last - offset][last] = mat[last][j];
				mat[last][j] = mat[j][i];
				mat[j][i] = top;
				//System.out.println(mat[j][i]);
			}
		}
	}
	
}
