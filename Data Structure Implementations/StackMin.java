import java.util.Stack;

public class StackMin extends Stack<Integer> {

	Stack<Integer> s2;
	public StackMin(){
		s2 = new Stack<Integer>();
	}
	public void push(int value) {
		if(value <= min()) 
			s2.push(value);
		super.push(value);
	}
	public Integer pop() {
		int value = super.pop();
		if(value == s2.peek())
			s2.pop();
		return value;
	}
	public int min() {
		if(s2.isEmpty())
			return Integer.MAX_VALUE;
		return s2.peek();
	}
	public void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(! r.isEmpty() && r.pop() > temp) {
				 s.push(r.pop());
			}
			r.push(temp);
		}
		while(!r.isEmpty())
			s.push(r.pop());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
