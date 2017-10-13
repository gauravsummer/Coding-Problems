package common;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,9};
		int target = 1;
		searchBinary(nums, target);
	}
	public static void searchBinary(int[] nums, int target){
		//int index = 0;
		int start = 0;
		int end = nums.length-1;
		int mid = 0;
		while(end > start) {
			mid = start + (end - start) / 2;
			//System.out.println("start " +start+" mid "+mid+" end "+end);
			if(target > nums[mid]) {
				start = mid + 1; 
			}
			else if(target < nums[mid]) {
				end = mid - 1; 
			}
			else if(target == nums[mid]) {
				System.out.println(mid); 
				break;
			}
		}
		if(start == end){
			//System.out.println("in");
			if(nums[start] == target)
				System.out.println(start);
			else 
				System.out.println("not in array");
		}
	}

}
