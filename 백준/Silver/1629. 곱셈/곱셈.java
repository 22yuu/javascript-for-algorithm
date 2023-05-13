import java.util.*;
import java.io.*;

public class Main {
	
	private static long N, M, C;
	
	public static long recrusion(long n, long m) {
		
		if(m == 1) {
			return n % C;
		}
		
		long ret = recrusion(n , m / 2);
		ret = (ret * ret) % C;
		
		if(m % 2 == 1) {
			ret = (ret * n) % C;
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(recrusion(N, M) % C);
		
	}
}
