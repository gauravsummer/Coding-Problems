package common;

import java.util.Comparator;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello fuck u world!";
		char[] ch = str.toCharArray();
		System.out.println(rev(ch));	
	}
	
	
	public static char[] rev(char[] str) {
		//char[] str = s.toCharArray();
		int start = 0;
		int end = 0;
		int len = str.length;
		reverseString(str, start, len-1);
		while(end < len) {
			if(str[end] != ' ') { 
				start = end;
				while(end < len && str[end] != ' ') {
					end++;
				}
				end--;
				reverseString(str, start, end);
			}
			end++;
		}
		return str;
	}
	
			
	
	public static void reverseString(char[] str, int start, int end) {
		char temp;
		while(end > start) {
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	
	
	
	
	public static String reverse(String str) {
		int len = str.length();
		int chkInd = str.length()-1;
		int pointer=str.length()-1;
		StringBuffer sb = new StringBuffer();
		char[] s = str.toCharArray();
		while(chkInd >= 0) {
			if(s[chkInd] ==' '){
				for(int i=chkInd+1;i<=pointer;i++){
					sb.append(s[i]);
				}
				sb.append(" ");
				pointer=chkInd-1;
			}
			chkInd--;
		}
		for(int i=chkInd+1;i<=pointer;i++){
			sb.append(s[i]);
		}
		return sb.toString();
	}

}
