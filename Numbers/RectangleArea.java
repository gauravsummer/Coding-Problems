package numbers;

public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;
		System.out.println(area(A,B,C,D,E,F,G,H));
	}
	public static int area(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = (C-A) * (D-B);
		int area2 = (G-E) * (H-F);
		int area3 = 0;
		if(area1 > 0 && area2 > 0)
			area3 = (C-E) * (H-B);
		return area1+area2-area3;
	}
}
