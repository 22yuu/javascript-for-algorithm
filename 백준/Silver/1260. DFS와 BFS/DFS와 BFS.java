import java.util.*;
import java.io.*;

public class Main {
	
	private static int N, M, V; // 정점, 간선, 시작 위
	private static int[][] graph;
	private static boolean visited[];
	
	
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for(int i = 1; i <= N; i++) {
			if(graph[start][i] == 1 && !visited[i]) dfs(i);
		}
		
	}
	
	public static void bfs(int start) {
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int node = que.poll();
			System.out.print(node + " ");
			
			for(int i = 1; i <= N; i++) {
				if(graph[node][i] == 1 && !visited[i]) {
					que.offer(i);
					visited[i] = true;
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		V = Integer.parseInt(inputs[2]);
		
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= M; i++) {
			inputs = br.readLine().split(" ");
			
			int x = Integer.parseInt(inputs[0]);
			int y = Integer.parseInt(inputs[1]);
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);
	}

}
