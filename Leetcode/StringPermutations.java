package common;

public class StringPermutations {
	private boolean[] used;
	private String str;
	private StringBuilder out = new StringBuilder();

	public StringPermutations(String str) {
		this.str = str;
		used = new boolean[str.length()];
	}

	public void permute() {
		if(str.length() == out.length()) {
			System.out.println(out);
			return;
		}
		for(int i=0; i<str.length(); i++) {
			if(used[i])
				continue;
			out.append(str.charAt(i));
			used[i] = true;
			permute();
			used[i] = false;
			out.setLength(out.length() - 1);
		}
	}
}
