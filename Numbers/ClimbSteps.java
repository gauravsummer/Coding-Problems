package numbers;

import java.util.HashMap;
import java.util.Map;

public class ClimbSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 35;
		System.out.println(climbStairsDynamic(n));
	}
	public static int climbStairsMemo(int n) {
		if(n == 0 || n == 1 || n == 2){
	    	return n;}
	    Map<Integer, Integer> map = new HashMap();
	    if(map.containsKey(n))
	    	return map.get(n);
	    else
	    	map.put(n, climbStairsMemo(n-1)+climbStairsMemo(n-2));
	    return map.get(n);
	}
	public static int climbStairsDynamic(int n) {
		if(n == 0 || n == 1 || n == 2){
	    	return n;}
	    int[] val = new int[n];
	    val[0] = 1;
	    val[1] = 2;
	    for(int i=2; i<n; i++) {
	    	val[i] = val[i-1] + val[i-2];
	    }
	    return val[n-1];
	}

}
