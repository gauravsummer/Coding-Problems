package common;
import java.util.*; 
public class Common {
    public static void main(String[] args){
//////////////// Get input from user	//////////////////////////////////////////////////////
    	Scanner scan = new Scanner(System.in); 	
		String string1 = scan.next();			
		String string2 = scan.next();
		scan.close();							
/////////////// Computing length of input strings//////////
		int str1Len = string1.length();			
		int str2Len = string2.length();
///////////	Swapping strings so that the smaller input string remains as string1 ////////////
		if(str1Len > str2Len){
			String temp = string1;
			string1 = string2;
			string2 = temp;
		}
		int similarityCount = 0;				//////variable to keep count of similar substrings
		boolean finish = false;					//////flag to check whether there were any similarities
		for(int i = 0; i < string1.length(); i++){	//////only till the length of smaller string
			if(finish == true)					//////if flag is true, then there were no matches in previous iteration
				break;							//////no need to check further larger size substrings
			else{									
				HashSet<String> set1 = new HashSet<String>();	//////set to store substrings of string 1
				HashSet<String> set2 = new HashSet<String>();	//////set to store substrings of string 1
				for(int j = 0; j < string1.length()-i; j++){	//////till the  length of smaller string
    				String subString = string1.substring(j, j+i+1);	//////creating all substrings of size i for string1
    				set1.add(subString);		//////	adding substrings to HashSet set1
				}
				for(int j = 0; j < string2.length()-i; j++){	//////till the  length of larger string
					String subString = string2.substring(j, j+i+1);	//////	substrings of string2
					set2.add(subString);		//////	adding substrings to HashSet set2
        		}
				set1.retainAll(set2);			//////	set1 will contain intersection of set1 and set2
				if(set1.size() == 0)			//////	if set1 is empty i.e. no similar substrings of size i 
					finish=true;				//////	update flag to true so that there's no next iteration
				similarityCount = similarityCount + set1.size();	/////	updating the variable with similarities	
			}
		}
   		System.out.println(similarityCount);			//////	Printing the number of total similar substrings
   	}
}