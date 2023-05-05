import java.util.*;
import java.io.*;

public class Main {
	
	public static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] psum = new int[100001];
		int temp = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			temp = Integer.parseInt(st.nextToken());
			psum[i] = psum[i - 1] + temp;
		}
		
		for(int i = K; i <= N; i++) {
			MAX = Math.max(MAX, psum[i] - psum[i - K]);
		}
			
		System.out.println(MAX);
		return;
	}
}
