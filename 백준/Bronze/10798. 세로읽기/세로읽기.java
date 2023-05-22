import java.util.*;
import java.io.*;

public class Main {
	
	private static int N = 5;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String answer = "";
		
		String[][] words = new String[N][15];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			Arrays.fill(words[i], "");
			
			for(int j = 0; j < str.length(); j++) {
				words[i][j] = str.charAt(j) + "";
			}
		}
		
		for(int j = 0; j < 15; j++) {
			for(int i = 0; i < N; i++) {
				answer += words[i][j];
			}
		}
		System.out.println(answer);
	}
}
