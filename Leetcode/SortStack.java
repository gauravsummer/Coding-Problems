package common;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> a = new Stack<Integer>();
		a.push(5);
		a.push(14);
		a.push(13);
		a.push(12);
		a.push(10);
		a.push(58);
		System.out.println(a);
		System.out.println("sorting ...");
		a = sortStack(a);
		System.out.println(a);
	}	
	public static Stack<Integer> sortStack(Stack<Integer> a) {
		Stack<Integer> b = new Stack<Integer>();
		while(!a.isEmpty()) {
			int tmp = a.pop();
			while(!b.isEmpty() && b.peek() > tmp) {
				a.push(b.pop());
			}
			b.push(tmp);
		}
		return b;
			
	}

}
