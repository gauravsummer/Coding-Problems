package numbers;

public class EqualArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(minMoves(nums));
	}
	public static int minMoves(int[] nums) {
		int min = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(nums[i] < min)
				min = nums[i];
		}
		int res = 0;
		for(int n: nums) {
			res = res +(n - min);
		}
		return res;
	}
}
