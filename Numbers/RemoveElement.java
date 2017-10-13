package numbers;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,2,2,4,5,7,6,8};
		System.out.println(remove(num,2));
	}
	public static int remove(int[] nums, int val) {
		int count = 0;
		int j = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == val) {
				count++;
			}
			else {
				nums[j]  = nums[i];
				j++;
			}		
		}
		return nums.length - count;
	}
}
