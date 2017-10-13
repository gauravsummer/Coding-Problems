package common;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormat formatter;
	      formatter = new SimpleDateFormat("dd-MMM-yyyy");
	      DateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss.SSSSSS");
	    	  String text = "2011-10-02 12:12:12";
	          Timestamp ts = Timestamp.valueOf(text);
	          String parsedDate = df.format(ts);
			System.out.println(parsedDate);
		
	      
	}

}
