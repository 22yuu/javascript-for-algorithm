import java.util.*;
import java.io.*;

public class Main {
	
	public static int T, M, N, K, answer;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	
	public static class Pointer {
		int x, y;
		
		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Pointer> que = new LinkedList<>();
		
		que.offer(new Pointer(x, y));
		visited[x][y] = true;
		answer += 1;
		
		while(!que.isEmpty()) {
			Pointer np = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny] == 0) continue;
				
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				que.offer(new Pointer(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			answer = 0;
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) bfs(i, j);
				}
			}
			
			System.out.println(answer);
		}
	}
}
