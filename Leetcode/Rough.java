package common;
import java.util.*; 
public class Rough {

    public static void main(String[] args){
    	Scanner scan=new Scanner(System.in);
    		String string1=scan.next();
    		String string2=scan.next();
    		scan.close();
    		ArrayList<String> strArray1 = new ArrayList<String>();
    		for(int i = 0;i<=string1.length();i++){
    			for(int j = 0; j<string1.length()-i;j++){
    				String sample1=string1.substring(j, j+i+1);
    				strArray1.add(sample1);
    			}
    		}
    		ArrayList<String> listCommon = new ArrayList<String>();
       		ArrayList<String> compare = new ArrayList<String>();
    		int index=0;
    		for(int i = 0; i<=string1.length(); i++){
    			if(i<string1.length()){
    				int toIndex=index+string1.length()-i;
    				if(i>string1.length())
    					toIndex=index;
    				compare=new ArrayList<String>(strArray1.subList(index, toIndex));
    				for(int j = 0; j<string2.length()-i;j++){
    				String subString=string2.substring(j, j+i+1);
    				if(compare.contains(subString) && !listCommon.contains(subString)){
        			listCommon.add(subString);
        			}
    			}index=index+string1.length()-i;
    			}
        	}
    		System.out.println(listCommon.size());}
}
