package numbers;

public class MaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,4,6,8,3,6,9};
		System.out.println(maxProfit(a));
	}
	public static int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
		int profit = 0;
		int min = prices[0];
		for(int i=1; i<prices.length; i++) {
			if(prices[i] < min)
				min = prices[i];
			else if(profit < prices[i] - min)
				profit = prices[i] - min;
		}
		return profit;
	}
}
