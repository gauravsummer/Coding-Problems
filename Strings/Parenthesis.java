package Strings;

import java.util.ArrayList;

public class Parenthesis {
static int total = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 3;
		ArrayList<String> par = paren(i);
		//System.out.println(paren(i));
		System.out.println(total);
		for(String s: par)
			System.out.println(s);
	}
	public static ArrayList<String> paren(int count) {
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		//int total = 0;
		addParen(list, count, count, str, 0);
		return list;
	}
	
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
		if(leftRem < 0 || rightRem < leftRem)
			return;
		if(leftRem==0 && rightRem==0)
		{
			String s = new String(str);
			list.add(s);
			total++;
			//System.out.println("t "+total);
		}
		else {
			if(leftRem > 0) {
				str[count] = '(';
				addParen(list, leftRem-1, rightRem, str, count+1);
			}
			if(rightRem > 0) {
				str[count] = ')';
				addParen(list, leftRem, rightRem-1, str, count+1);
			}
		}
	}
}
