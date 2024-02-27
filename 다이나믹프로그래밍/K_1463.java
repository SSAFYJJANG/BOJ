import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputN = Integer.parseInt(br.readLine());
		int[] dp = new int[inputN + 1];

		for (int i = 1; i <= inputN; i++) {
			if (i > 1) {
				dp[i] = 1 + dp[i - 1];
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(1 + dp[i / 2], dp[i]);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(1 + dp[i / 3], dp[i]);
			}
		}
		System.out.println(dp[inputN]);
	}
}
