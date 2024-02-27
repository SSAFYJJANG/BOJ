import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] home;
	static int ans = 0;
	
	static void f(int sR, int sC, int fR, int fC, int dir) {
		if (fR>=N || fC>=N) return;
		switch(dir) {
			case 0:
				if (home[fR][fC]==1) return;
				break;
			case 1: 
				if (home[fR][fC]==1) return;
				break;
			case 2:
				if (home[fR][fC]==1 || home[fR-1][fC]==1 || home[fR][fC-1]==1) return;
		}
		
		if (fR==N-1 && fC==N-1) {
			ans++;
			return;
		}
		
		switch(dir) {
			case 0:
				f(sR, sC+1, fR, fC+1, 0);
				f(sR, sC+1, fR+1, fC+1, 2);
				break;
			case 1:
				f(sR+1, sC, fR+1, fC, 1);
				f(sR+1, sC, fR+1, fC+1, 2);
				break;
			case 2:
				f(sR+1, sC+1, fR, fC+1, 0);
				f(sR+1, sC+1, fR+1, fC, 1);
				f(sR+1, sC+1, fR+1, fC+1, 2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][N];
		for (int i=0; i<N; i++)
			home[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();		
		f(0,0,0,1,0);
		System.out.println(ans);
	}
}