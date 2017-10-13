package numbers;

import java.util.Arrays;

public class Heaters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] house = {1,2,3,4,5,6};
		int[] heater = {1,5,6};
		System.out.println(findRadius(house, heater));
	}
	public static int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int i = 0, j = 0, result = 0;
		for(int heater:heaters) {
			
		}
	}
}
