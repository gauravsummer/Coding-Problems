package Strings;

public class CountSegments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "   ";
		System.out.println(countSegments(str));
	}
	public static int countSegments(String s) {
		char[] c = s.toCharArray();
        if(c.length == 0)
            return 0;
        int count = 0;
        if(c[0] != ' ')
            count++;
        for(int i=0; i<c.length-1; i++) {
            if(c[i] == ' ' && c[i+1] != ' ')
                count++;
            }
        return count;
    }
}
