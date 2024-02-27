import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] room;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		room = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// DFS
		pipeMove(0, 1, 0);
		System.out.println(cnt);
	}

	static void pipeMove(int r, int c, int d) {
		if (r < 0 || r >= N || c < 0 || c >= N)
			return;
		if (room[r][c] == 1)
			return;
		if(d == 1 && (room[r-1][c] == 1 || room[r][c-1] == 1))
			return;
		if (r == N - 1 && c == N - 1) {
			cnt++;
			return;
		}
		if (d != 2) pipeMove(r, c + 1, 0); // →↓↘
		pipeMove(r + 1, c + 1, 1);
		if (d != 0) pipeMove(r + 1, c, 2);
	}
}
