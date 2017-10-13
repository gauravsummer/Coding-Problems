package common;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Socks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int counter = 0;
        for(int i=0; i<n-1; i++){
            if(c[i] != 0){
                for(int j=i+1; j<n; j++){
                    if(c[i] == c[j]){
                        counter++;
                        c[i] = 0;
                        c[j] = 0;
                        break;
                    }   
                }
            }
        }
        System.out.println(counter);
    }
}
