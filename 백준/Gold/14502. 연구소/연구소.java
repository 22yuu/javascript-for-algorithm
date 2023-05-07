import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	
	public static List<int[]> listWalls;
	public static List<int[]> listVirus;
	
	public static int[][] Walls;
	public static int[][] Virus;
	
	public static int[] dx = {1, -1, 0, 0 };
	public static int[] dy = {0, 0, -1, 1};
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " " );
			}
			System.out.println();
		}
	}
	
	public static void dfs(int x, int y) {
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(visited[nx][ny]) continue;
			
			if(map[nx][ny] == 1) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
	
	
	public static int spread(int vSize) {
		
		visited = new boolean[N][M];
		
		for(int i = 0; i < vSize; i++) {
			
			int x = Virus[i][0];
			int y = Virus[i][1];
			
			visited[x][y] = true;
			dfs(x, y);
		}
		
		
		// 안전 영역 카운트
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 && !visited[i][j]) count++; // visited가 true라면 -> 바이러스가 퍼진 곳
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		listWalls = new ArrayList<>();
		listVirus = new ArrayList<>();
		
		int answer = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++ ) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) listWalls.add(new int[] {i, j}); // 모든 곳에 벽을 3개 씩 세워야 하는 완전 탐색이므로 벽을 세울 수 있는 0을 모조리 list에 넣음
				if(map[i][j] == 2) listVirus.add(new int[] {i, j});
			}
		}
		
//		print(); // 확인
		
		// list to array
		int wSize = listWalls.size();
		Walls = new int[wSize][1];
		
		for(int i = 0; i < wSize; i++) {
			Walls[i] = listWalls.get(i);
		}
		
		int vSize = listVirus.size();
		Virus = new int[vSize][1];
		
		for(int i = 0; i < vSize; i++) {
			Virus[i] = listVirus.get(i);
		}
		
		// 벽을 3개 세우는 로직
		for(int i = 0; i < wSize; i++) {
			for(int j = 0; j < i; j++) {
				for(int k = 0; k <j; k++) {
					map[Walls[i][0]][Walls[i][1]] = 1;
					map[Walls[j][0]][Walls[j][1]] = 1;
					map[Walls[k][0]][Walls[k][1]] = 1;
					
					answer = Math.max(answer, spread(vSize)); // spread: 바이러스 퍼지는 로직

					// 백트랙킹
					map[Walls[i][0]][Walls[i][1]] = 0;
					map[Walls[j][0]][Walls[j][1]] = 0;
					map[Walls[k][0]][Walls[k][1]] = 0;
				}
			}
		}
		System.out.println(answer);
	}
}
