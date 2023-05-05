import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		
		for(int i = 0; i < str.length / 2; i++) {
			if(!str[i].matches(str[str.length - 1 - i])) {
				System.out.println("0");
				return;
			}
		}
		
		System.out.println("1");
		
		return;
	}
}
