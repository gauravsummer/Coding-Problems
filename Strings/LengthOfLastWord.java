package Strings;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "asd ad da s dsdad d";
		System.out.println(length(str));
	}
	public static int length(String s) {
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
	}
}
