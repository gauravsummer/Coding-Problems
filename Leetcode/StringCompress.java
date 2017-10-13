package common;

public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdaaaaaaa";
		System.out.println(compress(str));
	}
	public static String compress(String str) {
		if(str.length()==0 || str.isEmpty()) {
			return ("String is empty");
			
		}
		else {
			if(!check(str))
				return str;
			else {
				StringBuffer s = new StringBuffer();
				char[] st = str.toCharArray(); 
				int count = 1;
				int last = 0;
				for(int i=1; i<str.length(); i++) {
					if(st[i] == st[last]) {
						count++;
					}
					else {
						s.append(st[last]);
						s.append(count);
						last = i;
						count = 1;
					}
				}
				s.append(st[last]);
				s.append(count);
				return new String(s);
			}
		}	
	}

	public static boolean check(String str) {
		if(str.length()==0 || str.isEmpty())
			return false;
		int last = 0;
		int count = 1;
		int size = 0;
		int ch = 0;
		char[] c = str.toCharArray();
		for(int i=1; i<c.length; i++) {
			
			if(c[i] == c[last]) {
				count++;
			}
			else {
				last = i;
				ch = String.valueOf(count).length();
				count = 1;
				size = size + ch + 1;
			}
		}
		ch = String.valueOf(count).length();
		size = size + ch + 1;
		System.out.println(size);
		if(size < str.length())
			return true;
		else
			return false;
	}
}
