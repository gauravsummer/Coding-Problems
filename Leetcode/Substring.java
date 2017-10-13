package common;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Substring {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String S = scan.nextLine();
        int k = scan.nextInt();
        String smallest=S.substring(0,k);
        String largest=S.substring(0,k);
        for(int j = 1; j <= S.length()-k; j++){
        	String b = S.substring(j, j+k);
                 //System.out.println(smallest +" " + b + " "+largest);
                if(smallest.compareTo(b) > 0){
                smallest = b;
                }
                if(largest.compareTo(b) <= 0){
                largest = b;
                }
            }
        
        System.out.println(smallest);
        System.out.println(largest);
    }
}