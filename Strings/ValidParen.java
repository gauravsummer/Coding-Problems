package Strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "([()])";
		System.out.println(valid(str));
	}
	public static boolean valid(String str) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		Stack<Character> stack = new Stack<Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		for(int i=0; i<str.length(); i++) {
			char curr = str.charAt(i);
			if(map.keySet().contains(curr))
				stack.push(curr);
			else if(map.values().contains(curr)) {
				if(!stack.isEmpty() && curr == map.get(stack.peek()))
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
	}
}
