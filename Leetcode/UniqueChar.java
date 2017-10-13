package common;

public class UniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "fgahv";
		System.out.println(unique(str));
	}
	public static boolean unique(String str) {
		if(str.length() > 256)
			return false;
		boolean[] charChk = new boolean[256];
		for(int i=0; i<str.length(); i++) {
			//System.out.println(charChk[str.charAt(i)]);
			if(charChk[str.charAt(i)]) {
				return false;
			}
			charChk[str.charAt(i)] = true;
		}
		return true;
	}

}
