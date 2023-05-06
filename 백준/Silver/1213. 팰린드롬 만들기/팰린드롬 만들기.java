import java.util.*;
import java.io.*;

public class Main {
	
	public static char[] alphabets;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		
		alphabets = new char[91];
		
		for(int i = 0; i < target.length(); i++) {
			alphabets[Integer.valueOf(target.charAt(i))]++;
		}
		
		int count = 0;
		String mid = "";
		String front = "";
		String back = "";
		for(int i = 'Z'; i >= 'A'; i--) {
			
			if(alphabets[i] % 2 == 1) {
				count += 1;
				mid = Character.toString(i);
				alphabets[i]--;
			}
			// 홀수가 2개 이상인 경우 팰린드롬이 성립 안됨
			if(count >=2) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
            // 홀수가 2개 미만인 경우 팰린드롬이 성립
			for(int j = 0; j < alphabets[i]; j+=2) {
				front = (char)i + front;
				back += (char)i;
			}
			
		}
		
		String answer = front + mid + back;
		
		System.out.println(answer);
	}
}