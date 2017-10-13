package Strings;

import java.util.ArrayList;
import java.util.List;

public class Modulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
        for(int i=1,fizz=0,buzz=0; i<=10; i++) {
            fizz++; buzz++;
            if(fizz == 3 && buzz == 5){
            	list.add("FizzBuzz");
            	fizz =0; buzz=0;
            }
            else if(fizz == 3){
            	list.add("Fizz");
            	fizz =0;
            }
            else if(buzz == 3){
            	list.add("Buzz");
            	buzz =0;
            }
            else
            	list.add(String.valueOf(i));
        }
	}

}
