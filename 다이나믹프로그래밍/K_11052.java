import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [] P = new int[N];
		int [] dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			P[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			dp[i] = P[i-1];
			for(int j = 1; j <= i/2; j++) {
				dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
			}
		}
		
		System.out.println(dp[N]);
		
	}

}
