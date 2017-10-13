package numbers;

public class FindNthDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 200;
		System.out.println(find(n));
	}
	public static int find(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
			System.out.println(n+" "+len+" "+count+" "+start);
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		System.out.println(n+" "+s);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
}
