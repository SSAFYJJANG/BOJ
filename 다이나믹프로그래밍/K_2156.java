import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int [] wine = new int[10_001];
		for(int i = 1; i <= n; i++)
			wine[i] = Integer.parseInt(br.readLine());
		
		int [] dp = new int[10_001];
		dp[0] = 0;
		dp[1] = wine[1];
		dp[2] = wine[1]+wine[2];
		dp[3] = Math.max(wine[1]+wine[2], Math.max(wine[2]+wine[3], wine[1]+wine[3]));
		for(int i = 4; i <= n; i++) {
			dp[i] = Math.max(wine[i]+wine[i-1]+dp[i-3], Math.max(wine[i]+dp[i-2], dp[i-1]));
		}
		System.out.println(dp[n]);
		
	}

}
