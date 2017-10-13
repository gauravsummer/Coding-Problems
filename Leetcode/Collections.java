package common;


import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Collections {
	public static void main(String[] args) {
////////////////////map//////////////////////////////////////////////
		
		// not stored in order
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		//stored based on entry order
		LinkedHashMap<Integer, String> linkedMap= new LinkedHashMap<Integer, String>();
		//stored in sorted order
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		/*for(Map.Entry<Integer, String> entry: map.entrySet()){
			System.out.println(entry.getKey()+": "+ entry.getValue());
		}*/
		//testMap(map);
		//testMap(linkedMap);
		//testMap(treeMap);
		
/////////////////////////////////SET//////////////////////////////////////////////
		//no duplicates
		// not retain order
		//Set<String> set1 = new HashSet<String>();
		//remembers the order you added
		//Set<String> linkedSet = new LinkedHashSet<String>();
		//treeset sords in natural order
		//Set<String> treeSet = new TreeSet<String>();
		treeMap.put(1, "ASd");
		treeMap.put(2, "bSd");
		treeMap.put(3, "cSd");
		System.out.println(treeMap.get(2));
		
		
		
		/*for(String elements: treeSet)
			System.out.println(elements);
		
		if(set1.contains("gaurav"))
			System.out.println("comtains gaurav");
		if(treeSet.contains("apple"))
			System.out.println("comtains apple");
		*/
		
		
		//Intersaction using set//////////////
		Set<String> set2 = new HashSet<String>();
		set2.add("apple");
		set2.add("boyset2");
		set2.add("catset2");
		set2.add("dog");
		//System.out.println(intersection);
		/////// intersection will have only intersection of set1 and set2///////
		//intersection.retainAll(set2);
		//System.out.println(intersection);
		
		//////Difference using sets///////////////////////
		//Set<String> difference = new HashSet<String>(set1);
		///set1-set2
		//difference.removeAll(set2);
		//System.out.println(difference);
	}
	
	public static void testMap(Map<Integer, String> map) {
		map.put(11, "Gaurav");
		map.put(22, "Satvik");
		map.put(3, "Ashis");
		map.put(4, "Pranav");
		map.put(1, "aaaaaa");
		map.put(2, "bbbbb");
		map.put(6, "cccccc");
		map.put(3, "ddddddddd");
		
		for(Integer key: map.keySet()){
			System.out.println(key +" : "+map.get(key));
		}
	}

	public static void sort(ArrayList<int[]> array, Comparator<int[]> comparator) {
		// TODO Auto-generated method stub
		
	}	
}
class ColumnComparator implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> ar1, ArrayList<Integer> ar2){
        return ar1.get(0).compareTo(ar2.get(0));
    }
}