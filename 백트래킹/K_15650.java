import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] inputNM;
	static int[] numbers;
	static boolean[] select;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputNM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		numbers = new int[inputNM[1]];
		select = new boolean[inputNM[0]+1];
		comb(0, 1);
	}

	public static void comb(int cnt, int start) {
		if (cnt == inputNM[1]) {
			Arrays.stream(numbers).forEach(i -> {System.out.print(i+" ");});
			System.out.println();
			return;
		}
		for (int i = start; i <= inputNM[0]; i++) {
			if (!select[i]) {
				select[i] = true;
				numbers[cnt] = i;
				comb(cnt + 1, i);
				select[i] = false;
			}
		}
	}
}