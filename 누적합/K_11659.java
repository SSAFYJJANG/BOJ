import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static ArrayList<Integer> numbers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] inputNM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		numbers.add(0);
		Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(i -> numbers.add(i));
		;
		// 누적합
		for (int i = 1; i <= inputNM[0]; i++) {
			numbers.set(i, numbers.get(i - 1) + numbers.get(i));
		}
		for (int i = 0; i < inputNM[1]; i++) {
			int[] sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			sb.append(numbers.get(sum[1]) - numbers.get(sum[0] - 1)).append("\n");
		}
		System.out.println(sb);
	}

}