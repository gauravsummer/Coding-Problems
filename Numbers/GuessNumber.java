package numbers;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		//int s = 20;
		System.out.println(search(n));
	}
	public static int search(int n){
		//int s = 20;
		int end  = n, start = 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			int check = check(mid);
			if(check == 0)
				return mid;
			else if(check == -1)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return 0;
	}
	public static int check(int n) {
		if(n == 20)
			return 0;
		else if(20 < n)
			return -1;
		else
			return 1;
				
	}
}
