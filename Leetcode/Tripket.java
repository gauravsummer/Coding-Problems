package common;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Tripket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<int[]> set = new HashSet<int[]>();
		int[] a = {-1, 0, 1, 2, -1, -4};
		List<Integer> ar = new ArrayList<Integer>();
		for(int i=0; i<a.length; i++){
			ar.add(a[i]);
		}
		Collections.sort(ar);
		for(int i=0; i<a.length-1; i++) {
			int j = i+1;
			for(int k = 0; k<a.length; k++) {
				if(k != i || k != j) {
					if(a[i]+a[j]+a[k] == 0) {
						System.out.println(a[i]+" "+a[j]+" "+a[k]);
					}
				}
			}
		}
	}

}
