package numbers;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,4,5,6};
		ArrayList<Integer> li = findDisappearedNumbers(nums);
		for(int i:li){
			System.out.println(i);
		}
	}
	
	public static ArrayList<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> lis = new ArrayList();
		int n = nums.length;
		for(int i=0; i<n; i++) {
			nums[(nums[i] - 1) % n] += n;
		}
		for(int i=0; i<n; i++) {
			if(nums[i] <= n)
				lis.add(i+1);
		}
		return lis;
	}
}
