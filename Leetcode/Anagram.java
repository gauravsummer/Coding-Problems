package common;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a1 = "zxcvbnmqwertyuiopasdfghjkl";
		String a2 = "asdfghjklqwertyuiopzxcvbnm";
		if(a1.length() != a2.length())
			System.out.println("false");
		else
		{
			char[] a = a1.toCharArray();
			//char[] b = a2.toCharArray();
			for(char i:a){
				if(a2.indexOf(i) == -1){
					System.out.println("false");
					break;
				}
				else{
					a2 = a2.substring(0, a2.indexOf(i)).concat(a2.substring(a2.indexOf(i)+1,a2.length()));
					//System.out.println(a2);
				}
			}
			if(a2.length()==0)
				System.out.println("true");
		}
	
					
	}

}
