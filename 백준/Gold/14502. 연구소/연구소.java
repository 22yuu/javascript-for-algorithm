import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, M;
	public static boolean visited[][];
	public static int[][] map;
	
	public static List<int[]> listWalls;
	public static List<int[]> listVirus;
	
	
	public static int Walls[][];
	public static int Virus[][];
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void print() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
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
		
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 && !visited[i][j]) count++;
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
		
		listWalls = new ArrayList<>();
		listVirus = new ArrayList<>();
		
		int answer = Integer.MIN_VALUE;
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) listWalls.add(new int[] {i, j});
				if(map[i][j] == 2) listVirus.add(new int[] {i, j});
			}
		}
		
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
		
		for(int i = 0; i < wSize; i++) {
			for(int j = 0; j < i; j++) {
				for(int k = 0; k < j; k++) {
					
					map[Walls[i][0]][Walls[i][1]] = 1;
					map[Walls[j][0]][Walls[j][1]] = 1;
					map[Walls[k][0]][Walls[k][1]] = 1;
					
					answer = Math.max(answer, spread(vSize));
					
					map[Walls[i][0]][Walls[i][1]] = 0;
					map[Walls[j][0]][Walls[j][1]] = 0;
					map[Walls[k][0]][Walls[k][1]] = 0;
				}
			}
		}
//		print();
		System.out.println(answer);	
	}
}
