import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
    	for (int tc=0; tc<T; tc++) {
    		int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            arr[0] = 1;
            arr[1] = 1;
            if (n>1) {
            	arr[2] = 2;
                for (int i=3; i<=n; i++) {
                	arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
                }
            }
            sb.append(arr[n]).append("\n");
    	}
        System.out.println(sb);
    }
}