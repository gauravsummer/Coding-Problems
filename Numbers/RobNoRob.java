package numbers;

public class RobNoRob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] value = {1,5,4,2,5,7,5,4,6,8,9};
		System.out.println(rob(value));
	}
	public static int rob(int[] value) {
		int lastRob = 0, lastNoRob = 0;
		for(int i=0; i<value.length; i++) {
			int curr = lastNoRob + value[i];
			lastNoRob = Math.max(lastRob, lastNoRob);
			lastRob = curr;
		}
		return Math.max(lastRob, lastNoRob);
	}
}
