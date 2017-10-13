package linkedList;

import java.util.Stack;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(4);
		stack.push(3);
		stack.push(1);
		stack.push(10);
		Stack<Integer> s1 = sort(stack);
		while(!s1.isEmpty()) {
			System.out.println(s1.pop());
		}
	}
	public static Stack<Integer> sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s1.isEmpty()) {
			int temp = s1.pop();
			while(!s2.isEmpty() && s2.peek() > temp) {
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		return s2;
	}
	
}


