package Strings;

public class searchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"abc","","gtr","","hsd","sdas","sdfd"};
		System.out.println(find(strs, "gtr"));
	}
	public static int find(String[] strs, String str) {
		if(strs == null || str == "" || str == null)
			return -1;
		int start = 0, end = strs.length - 1;
		while(start <= end) {
			System.out.println(start +" "+end);
			int mid = (start + end) / 2;
			if(strs[mid].isEmpty()) {
				int left = mid - 1;
				int right = mid + 1;
				while(left >= start && right <= end) {
					if(!strs[right].isEmpty()) {
						mid = right;
						break;
					}
					if(!strs[left].isEmpty()) {
						mid = left;
						break;
					}
					right++;
					left--;
					
				}
				System.out.println("mid "+mid);
			}
			if(strs[mid].equals(str))
				return mid;
			if(strs[mid].compareTo(str) < 0) {
				start = mid + 1;
			}
			else
				end = mid - 1;
		System.out.println(start+" "+end);
		}
		return -1;
	}
}
