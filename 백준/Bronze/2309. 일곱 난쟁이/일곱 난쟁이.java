import java.util.*;
import java.io.*;

public class Main {
	
	private static int N = 9; // 입력 난쟁이들의 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] heights = new int[N];
		int[] faker = new int[2];
		int[] answers = new int[7];
		
		int sum = 0;
		
		
		// 입력 받기
		for(int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(br.readLine());
			sum += heights[i]; // 전체를 더함
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(sum - heights[i] - heights[j] == 100) {
					faker[0] = i;
					faker[1] = j;
				}
			}
		}
		
		int index = 0;
		for(int i = 0; i < N; i++) {
			if(faker[0] == i || faker[1] == i) continue;
			
			answers[index++] = heights[i];
		}
		
		Arrays.sort(answers);
		
		for(int i = 0; i < answers.length; i++) {
			System.out.println(answers[i]);
		}
	}

}
