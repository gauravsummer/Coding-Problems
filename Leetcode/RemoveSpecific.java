package common;

public class RemoveSpecific {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Battle of the Vowels: Hawaii vs. Grozny"; 
		String remove = "randi";
		System.out.println(Remove(str, remove));
	}
	public static String Remove(String str, String remove) {
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		boolean[] flag = new boolean[128];
		for(int i=0; i<r.length; i++) {
			flag[r[i]] = true;
		}
		int j = 0;
		for(int i=0; i<s.length; i++) {
			if(!flag[s[i]]) {
				s[j] = s[i];
				j++;
			}
		}
		return new String(s,0,j);
	}

}
