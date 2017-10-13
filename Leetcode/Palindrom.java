package common;

import java.net.StandardSocketOptions;
import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str = "ascasdsadasdfgfdsa";
        System.out.println(Palen(str));
	}
	public static String Palen(String str) {
		char[] str1 = str.toCharArray();
		int start = 0;
		int start1 =0;
		int end = 0;
		int len = 0;
		int chk = 0;
		for(int i=0; i<str1.length ;i++) {
			int k = i;
			int count = 0;
			for(int j=str1.length-1; j>k; j--) {
				if(str1[k] == str1[j]) {
					if(count == 0)
						chk = j;
					k++;
					count++;
				}
				else {
					k = i;
					count=0;
				}
				if(count>0 && (chk-i+1) > len) {
					start = i;
				}
			}
			if(count>0 && (chk-i+1) > len){
				len = chk-i+1;
				start1=start;
				end = start+(count)*2;
			}
		}
		System.out.println(len);
		if(len%2 == 0)
			return new String(str1).substring(start1, end);
		else
			return new String(str1).substring(start1, end+1);
		
	}
}
