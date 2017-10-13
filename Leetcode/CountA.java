package common;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        char[] sc = s.toCharArray();
        long count = 0;
        for(int i = 0; i<sc.length; i++){
            if(sc[i]=='a')
                count++;    
        }
        long times = n/s.length();
        count = count*times;
        long mod = n % (s.length());
        for(int i=0; i<mod; i++){
            if(sc[i]=='a'){
                count++;
            }
        }
        System.out.println(count);
    }
}
