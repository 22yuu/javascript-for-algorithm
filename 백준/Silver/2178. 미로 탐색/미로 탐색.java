import java.util.*;
import java.io.*;

public class Main {
	
	private static int N, M;
	private static int[] dx = {-1, 1, 0, 0 };
	private static int[] dy = {0, 0, -1, 1 };
	private static int[][] map;
	private static boolean[][] visited;
	
	public static class Pointer {
		int x, y, count;
		
		public Pointer(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Pointer> que = new LinkedList<>();
		que.offer(new Pointer(x, y, 1));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Pointer np = que.poll();
			
			if(np.x == N-1 && np.y == M-1) {
				System.out.println(np.count);
			}
			
			for(int d = 0; d < 4; d++) {
				
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0) continue;
				
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				que.offer(new Pointer(nx, ny, np.count + 1));
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		br.close();
	}
}
