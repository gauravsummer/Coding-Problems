package common;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Cloud {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int i = 0;
        int counter = 0;
        while(i != (c.length-1)){
            if(c[i+1] == 0){
                if(c[i+2] == 0){
                    i = i+2;
                    counter++;
                }   
                else if(c[i+2] == 1){
                    i = i+1;
                    counter++;
                }
            }
            else if(c[i+1] == 1){
                i = i+2;
                counter++;
            }
        }
        System.out.println(counter);
    }
}
