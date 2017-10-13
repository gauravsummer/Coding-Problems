package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 > len2){
			return 1;
		}
		else if(len1 < len2) {
			return -1;
		}
		return 0;
	}	
}

class AlphabeticalOrder implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return s1.compareTo(s2);
	}	
}

class ReverseAlphabeticalOrder implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return -s1.compareTo(s2);
	}	
}


public class ComparatorOwn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> animals = new ArrayList<String>();
		animals.add("tiger");
		animals.add("giraf");
		animals.add("cat");
		animals.add("leopard");
		animals.add("elephant");
		animals.add("dog");
		//Collections.sort(animals);
		Collections.sort(animals, new StringLengthComparator());
		//Collections.sort(animals, new AlphabeticalOrder());
		//Collections.sort(animals, new ReverseAlphabeticalOrder());
		//for(String animal: animals)
			//	System.out.println(animal);
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(36);
		numbers.add(70);
		numbers.add(43);
		numbers.add(1);
		//for reverse order of numbers/////////////
		Collections.sort(numbers, new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				return -num1.compareTo(num2);
			}
		});
		
		for(String number: animals)
			System.out.println(number);
	}
}

