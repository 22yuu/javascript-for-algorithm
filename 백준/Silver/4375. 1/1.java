import java.util.*;
import java.io.*;


// 1을 계속 붙이는 로직 1개
// while 문을 돌아서 주어진 n에 나눠떨어지면 출력

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String line;
		
		
		while((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			sb = new StringBuilder();
			long res = 1; // 1을 계속 붙여줄 변수
			long cnt = 1; // 자리수
			
			while(true) {
				
				if(res % n == 0) {
					System.out.println(cnt);
					break;
				}
				res = (res * 10) + 1;
				res %= n;
				cnt += 1; // 자리 수
			}
		}
	}
}
