import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] inputNM = new int[2];
		for (int i = 0; i < 2; i++) {
			inputNM[i] = Integer.parseInt(st.nextToken());
		}

		int[][] numbers = new int[inputNM[0]][inputNM[0]];
		int[][] prefixSum = new int[inputNM[0] + 1][inputNM[0] + 1];

		for (int i = 0; i < inputNM[0]; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < inputNM[0]; j++)
				numbers[i][j] = Integer.parseInt(st.nextToken());
		}

		// 누적합
		for (int i = 1; i <= inputNM[0]; i++) {
			for (int j = 1; j <= inputNM[0]; j++) {
				prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1]
						+ numbers[i - 1][j - 1];
			}
		}

		int[] sum = new int[4];
		for (int i = 0; i < inputNM[1]; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				sum[j] = Integer.parseInt(st.nextToken());
			}
			int ans = prefixSum[sum[2]][sum[3]] - prefixSum[sum[2]][sum[1] - 1] - prefixSum[sum[0] - 1][sum[3]]
					+ prefixSum[sum[0] - 1][sum[1] - 1];
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}