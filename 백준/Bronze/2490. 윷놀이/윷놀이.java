import java.util.*;
import java.io.*;

public class Main {
	
	private static int T = 3;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i <T; i++) {
			int oneCount = 0;
			int zeroCount = 0;
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int value = Integer.parseInt(st.nextToken());
				
				if(value == 0) {
					zeroCount += 1;
				} else if(value == 1) {
					oneCount += 1;
				}
			}
			
			if(oneCount == 4) {
				System.out.println("E");
			} else if (oneCount == 1 && zeroCount == 3) {
				System.out.println("C");
			} else if (oneCount == 2 && zeroCount == 2) {
				System.out.println("B");
			} else if (oneCount == 3 && zeroCount == 1) {
				System.out.println("A");
			} else {
				System.out.println("D");
			}
		}
		
	}
}
