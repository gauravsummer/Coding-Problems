package common;

public class SpaceReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello world whats up";
		char[] str = s.toCharArray();
		System.out.println(replace(str));
	}
	
	public static String replace(char[] str) {
		int space = 0;
		int newLen = 0;
		
		for(int i=0; i<str.length; i++) {
			if(str[i]==' ') {
				space++;
			}
		}
		newLen = str.length + 2 * space;
		char[] newChar = new char[newLen];
		for(int i=str.length-1; i>=0; i--) {
			if(str[i]==' ') {
				newChar[newLen - 1] = '0';
				newChar[newLen - 2] = '2';
				newChar[newLen - 3] = '%';
				newLen = newLen-3;
			}
			else {
				newChar[newLen-1] = str[i];
				newLen--;
			}
		}
		return new String(newChar);
	}
}
