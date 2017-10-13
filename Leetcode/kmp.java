package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class kmp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String haystack;
		String needle;
		
		// If no file is given as input, generating haystack and needle //
		if (args.length == 0) {
            //System.out.println("no arguments were given.");
            StringBuilder sb = new StringBuilder();
    		StringBuilder ss = new StringBuilder();
    		for(int i=0; i<10000; i++) {
    			sb.append("aabaabaabaabaabaab");
    		}
    		sb.append("aabaabaabaabaabaabb");
    		for(int i=0; i<500; i++) {
    			ss.append("aabaabaabaabaabaab");
    		}
    		ss.append("aabaabaabaabaabaabb");
    		haystack = sb.toString();
    		needle = ss.toString();
        }
		
		// If file is given as argument then using that files lines as string and substring //
		else {
			String path = args[0];
			FileInputStream fis = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			haystack = br.readLine();
    		needle = br.readLine();
			br.close();
			fis.close();
		}
		long t0 = 0;
		long t1 = 0;
		
		// Function calls and output print //
		t0 = getMilliseconds();
		System.out.println("match found at "+naiveSearch(haystack, needle));
		t1 = getMilliseconds();
		System.out.println("naive search time: "+(t1 - t0));
		
		t0 = getMilliseconds();
		System.out.println("match found at "+standardSearch(haystack, needle));
		t1 = getMilliseconds();
		System.out.println("standard search time: "+(t1 - t0));
		
		t0 = getMilliseconds();
		System.out.println("match found at "+kmp(haystack, needle));
		t1 = getMilliseconds();
		System.out.println("kmp search time: "+(t1 - t0));		
	}
	
	/* Function for naive n square order search of substring in given string*/
	public static int naiveSearch(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		char[] t = haystack.toCharArray();
		char[] p = needle.toCharArray();
		for(int s=0; s<=n-m+1; s++) {
			int k = 0;
			for(k=0; k<m; ) {
				if(p[k] == t[s+k]) {
					k++;
				}
				else {
					break;
				}
			}
			if(k == m) {
				return s;
			}	
		}
		return -1;
	}
	
	/* Function for standard search of substring in given string*/
	public static int standardSearch(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
	
	/* KMP search function which returns the position of the substring(needle) 
	 * in given string(haystack)*/
	public static int kmp(String haystack, String needle) {
		int[] p = computePrefix(needle);
		int n = haystack.length();
		int m = needle.length();
		int q = 0;
		for(int i=0; i<n; i++) {
			while(q>0 && needle.charAt(q) != haystack.charAt(i))
				q = p[q-1];
			if(needle.charAt(q) == haystack.charAt(i))
				q = q+1;
			if(q == m) {
				return i-m+1;
			}
		}
		return -1;
	}
	
	/* To build prefix table and return it to kmp() */
	public static int[] computePrefix(String p) {
		int[] pattern = new int[p.length()];
		int m = p.length();
		pattern[0] = 0;
		int k = 0;
		for(int q=1; q<m; q++) {
			while(k>0 && p.charAt(k) != p.charAt(q)) {
				
				k = pattern[k-1];
			}
			if(p.charAt(k) == p.charAt(q)) {
				k = k+1;
			}
			pattern[q] = k;
		}
		return pattern;
	}
	
	/* To get current time 	*/
	public static long getMilliseconds() {
		return System.currentTimeMillis();
	}
	
}
