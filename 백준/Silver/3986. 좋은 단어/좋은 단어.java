import java.util.*;
import java.io.*;

public class Main {

	private static int N;
	private static int count;
	private static Stack<Character> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		count = 0;
		N = Integer.valueOf(st.nextToken());
		
		for(int i  = 0; i < N; i++) {
			String str = br.readLine();
			stack = new Stack<>();
			char ch = str.charAt(0);
			stack.push(ch);
			
			for(int j = 1; j < str.length(); j++) {
				
				if(!stack.isEmpty()) {
					char peek = stack.peek();
					if(peek == str.charAt(j)) {
						stack.pop();
						continue;
					}
				}
				stack.push(str.charAt(j));
			}	
			if(stack.isEmpty()) count++;
		}
		System.out.print(count);
	}
}