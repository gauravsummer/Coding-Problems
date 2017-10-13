package Strings;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ad asda sd  ds ad sada";
		System.out.println(palindrome(str));
	}
	public static boolean palindrome(String s) {
		char[] cs = s.toCharArray();
		int start = 0, end = s.length()-1;
		char cStart, cEnd;
		while(start <= end) {
			cStart = cs[start];
			cEnd = cs[end];
			if(!Character.isLetterOrDigit(cStart))
				start++;
			else if(!Character.isLetterOrDigit(cEnd))
				end--;
			else {
				if(Character.toLowerCase(cStart) != Character.toLowerCase(cEnd))
					return false;
				start++;
				end--;
			}		
		}	
		return true;
	}
}
