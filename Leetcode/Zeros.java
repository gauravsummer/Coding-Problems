package common;

public class Zeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in = 1023001001;
		char[] c = Integer.toString(in).toCharArray();
		
		int noZero = 0;
		for(int i=0; i<c.length; i++) {
			if(c[i] == '0') {
				noZero++;
			}
		}
		int index = 0;
		int zind = c.length-1;
		for(int i=0; i<c.length; i++) {
			if(c[i] != '0') {
				c[index++] = c[i];
			}	
		}
		for(int i=index; i<c.length; i++) {
			c[index++] = '0';
				
		}
		System.out.println(new String(c));
	}	
	

}
