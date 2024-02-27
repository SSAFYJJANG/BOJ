import java.io.*;
import java.util.*;

public class Main {
	static int N, M, r[];
	static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    
	public static void f(int idx, int start) {
		if (idx == M) {
			for (int i=0; i<M; i++)
				sb.append(r[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i=start; i<=N; i++) {
			if (!check[i]) {
				check[i] = true;
				r[idx] = i;
				f(idx+1, i+1);
				check[i] = false;
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = new int[M];
        check = new boolean[N+1];
        f(0, 1);
        System.out.println(sb);
    }
}
