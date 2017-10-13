package Implementation;

class MyStack {
	private int maxSize;
	private long[] stackArray;
	private int top;
	public MyStack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	public void push(long item) {
		if(!isFull())
			stackArray[++top] = item;
		else
			System.out.println("Stack is full can't insert "+item);
	}
	public long pop() {
		return stackArray[top--];
	}
	public long peek() {
		return stackArray[top];
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
}
public class StackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack = new MyStack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}

}
