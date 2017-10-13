package numbers;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,4,1,1,2,2,2,3,3,3};
		System.out.println(single(nums));
	}
	public static int single(int[] nums){
	
		Map<Integer,Integer> map = new HashMap();
		int num = 0;
		for(int i=0; i<nums.length; i++) {
			num = nums[i];
			if(!map.containsKey(num)){
				map.put(num, 1);
			}
			else if(map.get(num) == 2)
				map.remove(num);
			else {
				map.put(num, 2);
			}
		}
		return (int)map.keySet().toArray()[0];
	}
}
