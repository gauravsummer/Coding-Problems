package common;

import java.util.Scanner;

public class Pangram {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = str.trim().toLowerCase();
        char[] c = str.toCharArray();
        int[] a = new int[26];
        int counter = 0;
        System.out.println(str);
        for(int i=0; i<c.length; i++){
            
           // System.out.println(c[i]);
            if(c[i] >= 97 && c[i]<=122)
                a[c[i]-97]++;
        }
        
        for(int i=0; i<a.length; i++){
            if(a[i] > 0){
            	counter++;
            }
                
        }
        System.out.println(counter);
        if(counter == 26)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }
}
