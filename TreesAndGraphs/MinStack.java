package TreesAndGraphs;

import java.util.Stack;

public class MinStack {
	static class minStack extends Stack<Integer> {
		Stack<Integer> s2;
		public minStack() {
			s2 = new Stack<Integer>();
		}
		public int min() {
			if(s2.isEmpty())
				return Integer.MAX_VALUE;
			else
				return s2.peek();
		}
		public void push(int val) {
			if(val <= min()) {
				s2.push(val);
			}
			super.push(val);
		}
		public Integer pop() {
			int val = super.pop();
			if(val == s2.peek())
				s2.pop();
			return val;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minS = new MinStack();
		minStack min = new minStack();
		min.push(5);
		min.push(4);
		min.push(3);
		min.push(2);
		min.push(1);
		System.out.println(min.pop());
		System.out.println(min.min());
		System.out.println(min.pop());
		System.out.println(min.min());
		System.out.println(min.pop());
		System.out.println(min.min());
		System.out.println(min.pop());
		System.out.println(min.min());
	}

}



