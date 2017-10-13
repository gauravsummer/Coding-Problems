package common;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Time {
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    String time = in.next();
	    String[] arr = time.split(":");
	    String hours = arr[0];
	    String mins = arr[1];
	    String sec = arr[2].substring(0, 2);
	    String m = arr[2].substring(2);
	    int hrs = 0;
	    if(m.equalsIgnoreCase("PM") && Integer.parseInt(hours) < 12){
	    	hrs = 12 + Integer.parseInt(hours);
	    	hours = Integer.toString(hrs);
	    }
	    if(m.equalsIgnoreCase("AM") && Integer.parseInt(hours) == 12)
	    	hours = "00";
	    System.out.println(hours+":"+mins+":"+sec);
	}
	    

}
