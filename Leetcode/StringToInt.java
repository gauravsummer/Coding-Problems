package common;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "1111";
		Integer i = -1111111111;
		//System.out.println(strInt(s)*2);
		System.out.println(intStr(i));
	}
	public static int strInt(String s) {
		int no = 0;
		int ln = s.length();
		boolean isNeg = false;
		for(int i=0; i<ln; i++) {
			if(s.charAt(i) == '-') {
				isNeg = true;
				i++;
			}
			no = no*10 + s.charAt(i) - '0';
		}
		if(isNeg) {
			return -no; 
		}
		else
			return no;
	}
	
	public static String intStr(Integer in) {
		//String str = "";
		boolean isNeg = false;
		char[] cha = new char[11];
		int i = 0;
		if(in < 0) {
			isNeg = true;
			in = -in;
		}
		do {
			char c = (char)(in % 10+'0');
			in = in/10;
			cha[i] = c; 
			i++;
		}while(in != 0);
		StringBuilder b = new StringBuilder();
		if(isNeg)
			b.append('-');
		i--;
		while(i >= 0){
			b.append(cha[i]);
			i--;
		}
		return b.toString();
	}
}
