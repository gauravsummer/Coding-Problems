package common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class CharSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//String str = scan.next();
		String str = "trhhhaasdbnlgekrlkgjelnjjjj";
		System.out.println(sort(str));
	}
	public static String sort(String s) {
		char[] str = s.toCharArray();
        int[] count = new int[128];
        ArrayList<int[]> array = new ArrayList<int[]>();
        int i=0;
        for(i=0; i<str.length; i++) {
        	count[str[i]]++;
        }
        
        for(i=0; i<128; i++) {
        	if(count[i] > 0) {
        		int[] a ={count[i], i} ;
        		array.add(a);
        	}
        }
        java.util.Collections.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(b[0], a[0]);
			}
        });
        int index = 0;
        	for(int[] ar :array) {
        		char cha = (char)ar[1];
        		for(i=0; i<ar[0]; i++) {
        			str[index] = cha;
        			index++;
        		}
        	}
        return new String(str);
	}
}
