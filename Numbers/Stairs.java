package numbers;

import java.util.HashMap;

public class Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stairs = 4;
		System.out.println(countWays(stairs));
	}
	
	public static long countWays(int stairs) {
		if(stairs<0)
			return 0;
		if(stairs <= 2)
			return stairs;
		if(stairs == 3)
			return 4;
		long[] map = new long[stairs];
		map[0] = 1;
		map[1] = 2;
		map[2] = 4;
		for(int i=3; i<stairs; i++) {
			map[i] = map[i-1]+map[i-2]+map[i-3];
		}
		return map[stairs-1];
	}

}
