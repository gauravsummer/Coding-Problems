package numbers;

public class ArrangingCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(arrangeCoins(n));
	}
	public static int arrangeCoins(int n) {
		long st = 0;
		long end = n;
		long mid = 0;
		while(st <= end) {
			mid = st + (end-st)/2;
			if(mid * (mid+1)/2 <= n) {
				st = mid + 1;
			}
			else
				end = mid - 1;
		}
		return (int)st-1;
	}
}
