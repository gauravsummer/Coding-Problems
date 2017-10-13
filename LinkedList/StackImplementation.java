package linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementation {
class myStack {
	Queue<Integer> q = new LinkedList<Integer>();
	public void push(int x) {
        q.add(x);
        int n = q.size();
        while(n-- > 1) {
        	q.add(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
