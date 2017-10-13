package numbers;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,2,3,4,5,6,6};
		System.out.println(remove(nums));
	}
	public static int remove(int[] nums) {
		int n =nums.length;
		if(n < 2)
			return n;
		int id = 1;
		for(int i=1; i<n; i++) {
			if(nums[i] > nums[i-1]) {
				nums[id++] = nums[i];
			}
		}
		return id;
		
	}
}
