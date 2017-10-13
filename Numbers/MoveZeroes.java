package numbers;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,0,3,12};
		move(a);
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static int[] move(int[] nums) {
		int i = 0;
		for(int j=0; j<nums.length; j++) {
			if(nums[j] != 0) {
				nums[i++] = nums[j];
			}
		}
		for(int j=i; j<nums.length; j++) {
			nums[j] = 0;
		}
		return nums;
	}
}
