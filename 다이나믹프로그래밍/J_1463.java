import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[1] = 0;
        for (int i=2; i<=N; i++) {
            if (i%6 == 0) {
                arr[i] = Math.min(arr[i/3], Math.min(arr[i/2], arr[i-1])) + 1;
            } else if (i%3 == 0) {
                arr[i] = Math.min(arr[i/3], arr[i-1]) + 1;
            } else if (i%2 == 0) {
                arr[i] = Math.min(arr[i/2], arr[i-1]) + 1;
            } else {
                arr[i] = arr[i-1] + 1;
            }
        }
        System.out.println(arr[N]);
    }
}