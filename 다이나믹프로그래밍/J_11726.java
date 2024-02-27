import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] c = new int[n+1];
        c[1] = 1;
        if (n>1) {
            c[2] = 2;
            for (int i=3; i<=n; i++) {
                c[i] = c[i-1] + c[i-2];
                c[i] %= 10007;
            }
        }
        System.out.println(c[n]);
    }
}