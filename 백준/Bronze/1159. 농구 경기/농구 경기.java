import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] alphabets;
	public static String[] names;
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "";
		
		int N = Integer.parseInt(br.readLine());
		
		names = new String[N];
		alphabets = new int[26];
		
		for(int i = 0; i < N; i++) {
			names[i] = br.readLine();
		}
		
		for(int i = 0; i < names.length; i++) {
			int alpha = names[i].charAt(0) - 'a';
			alphabets[alpha]++;
		}
		
		int a = (int)'a';
		
		for(int i = 0; i < alphabets.length; i++) {
			
			if(alphabets[i] >= 5) {
				answer += (char)(i + a);
			}
		}
		
		char[] chars = answer.toCharArray();
		Arrays.sort(chars);
		answer = new String(chars);
        
		if(!answer.equals("")) {
			System.out.println(answer);
		} else {
			System.out.println("PREDAJA");
		}
		
	}
}
