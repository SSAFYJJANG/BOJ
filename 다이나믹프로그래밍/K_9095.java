import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		
		int[] dp = new int[12];
		dp[0] = 1; // 자기 자신 호출한 경우(2 = 2, 3 = 3)
		dp[1] = 1; // 합산 결과 1
		dp[2] = 2; // 합산 결과 2
		for (int i = 3; i <= 11; i++) {
			dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]);
		}
		
		for (int t = 0; t < test; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.print(sb);
	}
}
