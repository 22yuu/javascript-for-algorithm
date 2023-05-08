import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static Map<Integer, Integer> hm;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		hm = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(hm.containsKey(num)) answer++;
			hm.put(M - num, i);
		}
		System.out.println(answer);
	}
}
