import java.util.*;
import java.io.*;

public class Main {
	
	private static int TARGET;
	private static boolean[] visited = new boolean[100001];
	private static Queue<Integer> que;
	
	public static boolean isAvailable(int num) {
		if( num < 0 || num > 100000 || visited[num]) {
			return false;
		}
		
		return true;
	}
	
	public static void bfs(int time) {
		
		
		while(true) {
			
			time++;
			int size = que.size();
			for(int i = 0; i < size; i++) {
				int value = que.remove();
                visited[value] = true;
                
				if(value == TARGET) {
					System.out.println(time - 1);
					return;
				}
				
				if(isAvailable(value - 1)) {
					visited[value - 1] = true;
					que.add(value - 1);
				} 
				
				if(isAvailable(value + 1)) {
					visited[value + 1] = true;
					que.add(value + 1);
				}
				
				if(isAvailable(value * 2)) {
					visited[value * 2] = true;
					que.add(value * 2);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		que = new LinkedList<>();
		
		int start = Integer.parseInt(inputs[0]);
		TARGET = Integer.parseInt(inputs[1]);
		
		if(start == TARGET) {
			System.out.println(0);
			return;
		}
		
		que.add(start);
		visited[start] = true;
		bfs(0);
	}
}
