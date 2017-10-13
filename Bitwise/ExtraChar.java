package bitwise;

public class ExtraChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abba", b="ba0ab";
		char c = 0;
		for(char ch: a.toCharArray())
			c^=ch;
		for(char ch: b.toCharArray())
			c^=ch;
		System.out.println(c);
	}

}
